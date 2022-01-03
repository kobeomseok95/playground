package com.example.effectivejava.serialize;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Slf4j
public class SerializeMain {

    public static void main(String[] args) {
        SerializeMain main = new SerializeMain();
        String path = "/Users/kobeomseok95/Desktop/serialize.md";

        SerialDTO dto = new SerialDTO("고범석", 1, true, 100);
//        main.saveDto(path, dto);
        main.loadDto(path);
    }

    private void loadDto(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            SerialDTO dto = (SerialDTO)obj;
            log.info("{}", dto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveDto(String path, SerialDTO dto) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(dto);
            log.info("Write Success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
