/* FileLoader.java 
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/* FileLoader 
*/
public class FileLoader {
    /** 
    * �t�B�[���h 
    */
    private String fileName;

    /** �R���X�g���N�^ FileLoader 
    * @param String fileName 
    */
    FileLoader(String fileName) {
        this.fileName = fileName;
    }

    /** read 
    * @param RecordList rl 
    * @throws Exception 
    */
    public void read(RecordList rl) throws Exception {
        // �t�@�C������fileName �̃t�@�C����ǂ� 
        BufferedReader input = null;
        try {
            try {
                input = new BufferedReader(new FileReader(fileName));
                String s;
                while ((s = input.readLine()) != null)
                    rl.add(s);
            } finally {
                if (input != null)
                    input.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName + "���J�����Ƃ��ł��܂���B");
            throw e;
        } catch (IOException e) {
            System.out.println("�t�@�C���Ǎ��ݒ��ɃG���[���������܂����B");
            throw e;
        }
    }
}