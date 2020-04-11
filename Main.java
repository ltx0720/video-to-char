import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author ltx
 * @Date 11:05 2020/4/10
 */
public class Main {

    public static char[] chars = {'M', 'N', 'H', 'Q', '$', 'O', 'C', '?', '7', '>', '!', ':', '-', ';', '.'};
    public static String[] strings = {"M", "N", "H", "Q", "$", "O", "C", "?", "7", ">", "!", ":", "-", ";", "."};

    public static void main(String[] args) throws IOException, InterruptedException {
        // 文件目录，视频的切帧图片
        readDir("C:/Users/LTX/Desktop/image1");
    }


    public static void readDir(String dirPath) throws IOException, InterruptedException {
        File file = new File(dirPath);
        File[] files = file.listFiles();

        BufferedImage image = null;

        for (int page = 0; page < files.length; page++) {
            image = ImageIO.read(files[page]);
            int width = image.getWidth();
            int height = image.getHeight();

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    int rgb = image.getRGB(i, j);
                    rgb = (rgb & 0xff0000) >> 16;
                    rgb = (rgb << 16) + (rgb << 8) + rgb;
                    image.setRGB(i, j, rgb);
                }
            }
            show(image, page, width, height);
        }
    }

    public static void show(BufferedImage image, int page, int width, int height) throws IOException {
//        System.out.println("page: " + page);
        for (int i = 0, row = 0; i < height &&   row < Config.ROWS; i += Config.ROWGAP, row++) {
            for (int j = 0, column = 0; j < width && column < Config.COLUMNS; j += Config.COLUMNGAP, column++) {
                int rgb = image.getRGB(j, i);

                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int avg = (r + g + b) / 3;
                int num = (int) Math.floor(avg / 18);

                if (page == 0) {
                    Frame.append(strings[num]);
                } else {
                    Frame.replaceOne(row, column, strings[num]);
                }
            }
            Frame.append();
        }
    }


    public static int getGray(Color pixel) {
        return (pixel.getRed() * 30 + pixel.getGreen() * 60 + pixel.getBlue() * 10) / 100;
    }

//    public static void showConsole(char c) {
//        System.out.print(c);
//    }
//
//    public static void showTextarea(JTextArea textArea, int lineNum, String s) {
//        int rows = textArea.getRows();
//        if (rows < lineNum) {
//            textArea.append(s);
//        } else {
////            textArea.replaceRange();
//        }
//    }
//




//    // 濞撳懎鐫?
//    public static void clear() throws IOException, InterruptedException {
//        new ProcessBuilder("cmd", "/c", "cls")
//                .inheritIO()
//                .start()
//                .waitFor();
//    }
//
//    public static void turnToHui(String inputPath) throws IOException, InterruptedException {
//        File f = new File(inputPath);
//        BufferedImage image = null;
//
//        image = ImageIO.read(f);
//        int width = image.getWidth();
//        int height = image.getHeight();
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                int rgb = image.getRGB(i, j);
//                rgb = (rgb & 0xff0000) >> 16;
//                rgb = (rgb << 16) + (rgb << 8) + rgb;
//                image.setRGB(i, j, rgb);
//            }
//        }
//
//        int wnum = 5;
//        int hnum = 11;
////        show(image, width, height, wnum, hnum);
//    }


}
