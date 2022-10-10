/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class Data {

    public static void main(String[] args) {
        // Lưu ý:
        // MS Windows: \ => \\ | Ví dụ: "C:\\Thu muc 1\\Thuc muc\\Ten tap tin.xxx";
        // Linux, MacOS: / | Ví dụ: /Thu muc 1/Thuc muc 2 /Ten tap tin.xxx"

        // Kiểm tra thư mục hoặc tập tin có tồn tại hay không?
        File folder1 = new File("C:\\Java-JSP\\duan9");
        File folder2 = new File("C:\\Java-JSP\\duan10");
        System.out.println("Kiểm tra folder1 có tồn tại hay không: " + folder1.exists());
        System.out.println("Kiểm tra folder2 có tồn tại hay không: " + folder2.exists());

        // Tạo thư mục
        // Phương thức mkdir() => Tạo 1 thư mục
        File d1 = new File("C:\\Java-JSP\\duan9\\Directory_1");
        d1.mkdir();

        // Phương thức mkdirs() => Tạo nhiều thư mục cùng lúc
        File d2 = new File("C:\\Java-JSP\\duan9\\Directory_1\\Directory_2\\Directory_3\\Directory_4");
        //d2.mkdir();
        d2.mkdirs();

        // Tạo tập tin (có phần mở rộng: .exe, .txt, .doc, .xls .....)
        File file1 = new File("C:\\Java-JSP\\duan9\\Directory_1\\Vidu1.txt");
        File file2 = new File("C:\\Java-JSP\\duan9\\Directory_1\\Vidu2.txt");
        try {
            file1.createNewFile();
            file2.createNewFile();
        } catch (IOException e) {
            // Không có quyền tạo tập tin
            // Ổ cứng bị đầy
            // Đường dẫn sai
            e.printStackTrace();
        }
    }
}
