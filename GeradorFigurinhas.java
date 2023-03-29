import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {
    
    public void criar(InputStream inputStream, String nomeArquivo, String texto) throws Exception {
    //Caso queira utilizar um arquivo da própria máquina
    //BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filmaço.jpg"));
    
    //Caso queira utilizar uma url
    //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;

    BufferedImage novaimagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) novaimagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

   var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.WHITE);
    graphics.setFont(fonte);
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
    int larguratexto = (int) retangulo.getWidth();
    int posicaotextoX = (largura - larguratexto) / 2;
    graphics.drawString(texto, posicaotextoX, novaAltura - 100);



    ImageIO.write(novaimagem, "png", new File(nomeArquivo));


}



}


