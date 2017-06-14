/* FileSaver.java 
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/* FileSaver 
*/
public class FileSaver {
    /** 
    * �t�B�[���h 
    */
    private String fileName;

    /** �R���X�g���N�^ FileSaver 
    * @param String fileName 
    */
    FileSaver(String fileName) {
        this.fileName = fileName;
    }

    /** write 
    * @param RecordList rl 
    * @throws FileNotFoundException, IOException 
    */
    public void write(RecordList rl)
            throws FileNotFoundException, IOException {
        // �t�@�C������fileName �̃t�@�C���� 
        // �������݂��s�� 
        BufferedWriter output = null;
        try {
            try {
                output = new BufferedWriter(new FileWriter(fileName));
                // ��RecordList �Ɋi�[���ꂽ���R�[�h���P�s���������� 
                int idx = 0;
                Record r;
                while (idx < rl.size()) {
                    r = rl.getRecord(idx);
                    output.write(r.writeForCSV());
                    output.newLine(); // ��s�������t�@�C���ɏo�� 
                    idx++;
                }
            } finally {
                if (output != null)
                    output.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName + "���J�����Ƃ��ł��܂���B");
            throw e;
        } catch (IOException e) {
            System.out.println("�t�@�C�������ݒ��ɃG���[���������܂����B");
            throw e;
        }
    }
}