/* DisplayPersonStatus.java 
*/
/* DisplayPersonStatus 
*/
public class DisplayPersonStatus extends ConsoleStatus {
    // �t�B�[���h 
    private Person pe;
    private WorkList workList; // �ғ��󋵂𓾂邽�߂ɗp����ғ��̃��X�g 

    /** 
    * �R���X�g���N�^ DisplayPersonStatus 
    * @param String firstMess 
    * @param String promptMess 
    * @param boolean IsEndStatus 
    * @param WorkList workList 
    */
    DisplayPersonStatus(String firstMess, String promptMess,
            boolean IsEndStatus, WorkList workList) {
        super(firstMess, promptMess, IsEndStatus);
        this.pe = null;
        this.workList = workList;
    }

    /** setPersonRecord 
    * @param Person pe 
    */
    public void setPersonRecord(Person pe) {
        this.pe = pe;
    }

    /** 
    * displayFirstMess 
    */
    public void displayFirstMess() {
        displayPerson();
    }

    // �I�����ꂽ�]�ƈ���ID�C�����Ȃǂ� 
    // �\�����鏈�� 
    /** 
    * displayPerson 
    */
    public void displayPerson() {
        // �]�ƈ��̃��R�[�h�̓��e���o�� 
        System.out.println(pe.toString());
        System.out.println("�ғ���-------------------");
        // ���Y�]�ƈ������蓖�Ă��Ă��� 
        // �ғ��iWork�j��\�� 
        WorkList wl = workList.searchByPersonID(pe.getID());
        wl.allDisplay();
    }

    // ��͓��e�����ł��낤�ƁC 
    // �O�̏�Ԃɖ߂� 
    /** getNextStatus 
    * @param String s 
    * @return ConsoleStatus 
    */
    public ConsoleStatus getNextStatus(String s) {
        return super.getNextStatus(" ");
    }
}