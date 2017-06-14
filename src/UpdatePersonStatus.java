/* UpdatePersonStatus.java 
*/
import java.io.IOException;

/* UpdatePersonStatus 
*/
public class UpdatePersonStatus extends ConsoleStatus {
    // �t�B�[���h 
    private PersonList pl;
    private String[] messages = {
            "1.����\t\t\t2.�Z��\n",
            "3.�d�b�ԍ�\t\t4.�E��\n",
            "5.�Α��N��\t\t6.�P��\n"
    };
    private String data;

    /** 
    * �R���X�g���N�^ UpdatePersonStatus 
    * @param String firstMess 
    * @param String promptMess 
    * @param boolean IsEndStatus 
    * @param PersonList pl 
    */
    UpdatePersonStatus(String firstMess, String promptMess,
            boolean IsEndStatus, PersonList pl) {
        super(firstMess, promptMess, IsEndStatus);
        this.pl = pl;
        this.data = "";
    }

    // �ŏ��ɏo�͂��郁�b�Z�[�W��\������ 
    // ���̃N���X�ł͏]�ƈ��̃f�[�^�̍X�V���� 
    // �݂̂��s�� 
    /** displayFirstMess 
    * @throws IOException 
    */
    public void displayFirstMess() throws IOException {
        int id, no, num;
        // ID �̓�� 
        System.out.print("�]�ƈ�ID ���͂��Ă��������B\n>");
        data = inputMessage();
        try {
            id = Integer.parseInt(data); // �]�ƈ�ID 
        } catch (NumberFormatException e) {
            System.out.println("���l�ɕϊ��ł��Ȃ��f�[�^����͂���Ă��܂��B");
            System.out.println("�ē�͂��Ă��������B");
            displayFirstMess();
            return;
        }
        Person p = pl.get(id);
        if (p == null) {
            System.out.println("�w���ID �̏]�ƈ��͑��݂��܂���B");
            System.out.println("�ē�͂��Ă��������B");
            displayFirstMess();
            return;
        }
        // �]�ƈ��̏��̏o�� 
        System.out.println(p.toString());
        System.out.println("\n �X�V���������ڂ��͂��Ă��������B");
        // messages �̊e����������ɕ\������ 
        for (int idx = 0; idx < messages.length; idx++)
            System.out.print(messages[idx]);
        // �X�V���鍀�ڂ̔ԍ��̓�� 
        System.out.print("\n �X�V���鍀�ڂ̔ԍ����͂��Ă��������B\n>");
        data = inputMessage();
        try {
            no = Integer.parseInt(data); // �X�V���鍀�ڂ̔ԍ� 
            // �X�V����l�̓�� 
            System.out.print("\n �X�V��̒l���͂��Ă��������B\n>");
            data = inputMessage();
            if (no == 5 || no == 6) {
                num = Integer.parseInt(data); // �Α��N���܂��͒P�� 
                if (no == 5)
                    p.setWorkingYears(num);
                else
                    p.setPrice(num);
            }
            else if (no >= 1 && no <= 4) {
                switch (no) {
                case 1:
                    p.setName(data);
                    break;
                case 2:

                    p.setAddress(data);
                    break;
                case 3:
                    p.setTel(data);
                    break;
                case 4:
                    p.setType(data);
                    break;
                default:
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("���l�ɕϊ��ł��Ȃ��f�[�^����͂���Ă��܂��B");
            System.out.println("�ē�͂��Ă��������B");
            displayFirstMess();
            return;
        }
    }

    // ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W�̕\�� 
    // ���̃N���X�́C�����Ԃɖ߂�ƌ��܂��Ă��邽�߁C���� 
    // ��͂���Ă������ԂɑJ�ڂ���悤�ɂ��Ă��� 
    /** getNextStatus 
    * @param String s 
    * @return ConsoleStatus 
    */
    public ConsoleStatus getNextStatus(String s) {
        return super.getNextStatus(" ");
    }
}