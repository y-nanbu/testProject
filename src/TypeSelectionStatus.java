/* TypeSelectionStatus.java 
*/
import java.io.IOException;

/* TypeSelectionStatus 
*/
public class TypeSelectionStatus extends ConsoleStatus {
    // �t�B�[���h 
    private DisplayPersonsByTypeStatus next;

    /** 
    * �R���X�g���N�^ TypeSelectionStatus 
    * @param String firstMess 
    * @param String promptMess 
    * @param boolean IsEndStatus 
    * @param DisplayPersonsByTypeStatus next 
    */
    TypeSelectionStatus(String firstMess, String promptMess,
            boolean IsEndStatus,
            DisplayPersonsByTypeStatus next) {
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
        next.setWork(mess);
        return mess;
    }

    // ���̃N���X�́C����DisplayPersonsByTypeStatus ���ĂԂ� 
    // ���܂��Ă��邽�߁C������͂���Ă� 
    // DisplayPersonsByTypeStatus �ɑJ�ڂ���悤�ɂ��Ă��� 
    /** getNextStatus 
    * @param String s 
    * @return ConsoleStatus 
    */
    public ConsoleStatus getNextStatus(String s) {
        return next;
    }
}