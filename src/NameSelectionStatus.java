/* NameSelectionStatus.java 
*/
import java.io.IOException;

/* NameSelectionStatus 
*/
public class NameSelectionStatus extends ConsoleStatus {
    // �t�B�[���h 
    private DisplayPersonsByNameStatus next;

    /** 
    * �R���X�g���N�^ NameSelectionStatus 
    * @param String firstMess 
    * @param String promptMess 
    * @param boolean IsEndStatus 
    * @param DisplayPersonsByNameStatus next 
    */
    NameSelectionStatus(String firstMess, String promptMess,
            boolean IsEndStatus,
            DisplayPersonsByNameStatus next) {
        super(firstMess, promptMess, IsEndStatus);
        this.next = next;
    }

    // ���̏�ԂɑJ�ڂ��邱�Ƃ𑣂����߂̃��b�Z�[�W�̕\�� 
    /** inputMessage 
    * @throws IOException 
    * @return String 
    */
    public String inputMessage() throws IOException {
        String mess = super.inputMessage();
        next.setName(mess);
        return mess;
    }

    // ���̃N���X�́C����DisplayPersonsByNameStatus ���ĂԂ� 
    // ���܂��Ă��邽�߁C������͂���Ă� 
    // DisplayPersonsByNameStatus �ɑJ�ڂ���悤�ɂ��Ă��� 
    /** getNextStatus 
    * @param String s 
    * @return ConsoleStatus 
    
    */
    public ConsoleStatus getNextStatus(String s) {
        return next;
    }
}