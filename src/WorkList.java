/* WorkList.java 
*/
import java.util.List;
import java.util.ArrayList;

/* WorkList <- RecordList �C���^�t�F�[�X������ 
*/
public class WorkList implements RecordList {
    /** 
    * �t�B�[���h 
    */
    private List<Work> list;
    private ClientList c_list;

    /** �R���X�g���N�^ WorkList 
    * @param ClientList c_list 
    */
    WorkList(ClientList c_list) {
        this.list = new ArrayList<Work>();
        this.c_list = c_list;
    }

    /** �R���X�g���N�^ WorkList 
    
    - 45 - 
    * @param List<Work> al 
    * @param ClientList c_list 
    */
    WorkList(List<Work> al, ClientList c_list) {
        this.list = al;
        this.c_list = c_list;
    }

    /** size 
    * @return int 
    */
    public int size() {
        return list.size();
    }

    /** add 
    * @param Work w 
    */
    public void add(Work w) {
        for (int idx = 0; idx < list.size(); idx++) {
            Work widx = list.get(idx);
            if (widx.getID() == w.getID()) // ����ID �̃��R�[�h������ꍇ 
                return; // ���������I�� 
            else if (widx.getID() > w.getID()) {
                list.add(idx, w); // ���R�[�h��ǉ� 
                return;
            }
        }
        list.add(w); // ���X�g�����Ƀ��R�[�h��ǉ� 
    }

    /** add 
    * @param String data 
    * @throws Exception 
    */
    public void add(String data) throws Exception {
        Work w = new Work(data);
        add(w);
    }

    /** getRecord 
    * @param int idx 
    * @return Record 
    */
    public Record getRecord(int idx) {
        if (idx >= list.size())
            return null;
        else
            return list.get(idx);
    }

    /** delete 
    * @param int ID 
    * @return boolean 
    */
    public boolean delete(int ID) {
        Work w;
        if (find(ID) == -1)
            return false;
        else {

            w = get(ID);
            w.setEraseFlag(true);
            return true;
        }
    }

    /** 
    * allDisplay 
    */
    public void allDisplay() {
        for (Work w : list) {
            System.out.println(w.toString());
        }
    }

    // �ڋq���ƂƂ���ID�C�ғ��J�n�N����C�ғ��I���N������o�͂��� 
    /** 
    * displayWithClient 
    */
    public void displayWithClient() {
        Client c;
        for (Work w : list) {
            if (!w.getEraseFlag()) {
                System.out.print(w.getID() + "\t");
                System.out.print(w.getStartTime() + "�`");
                System.out.print(w.getEndTime() + "\t");
                c = c_list.get(w.getClientID());
                if (c != null)
                    System.out.println(c.getName());
                else
                    System.out.println("(�ڋq�������݂��܂���B)");
            }
        }
    }

    /** find 
    * @param int ID 
    * @return int 
    */
    public int find(int ID) {
        // ���ID �Ɠ���ID �������R�[�h�̈ʒu������ 
        for (int idx = 0; idx < list.size(); idx++) {
            Work widx = list.get(idx);
            if (widx.getID() == ID)
                return idx;
        }
        return -1;
    }

    /** get 
    * @param int ID 
    * @return Work 
    */
    public Work get(int ID) {
        Work w;
        // ���ID �Ɠ���ID �������R�[�h�����݂���Ȃ�΁C 

        // ���̃��R�[�h��Ԃ� 
        int idx;
        if ((idx = find(ID)) != -1) {
            w = list.get(idx);
            // �폜�t���O=false �Ȃ瓖�Y���R�[�h��Ԃ� 
            if (!w.getEraseFlag())
                return w;
            else
                return null;
        }
        else
            return null;
    }

    /** searchByPersonID 
    * @param int pID 
    * @return WorkList 
    */
    public WorkList searchByPersonID(int pID) {
        ArrayList<Work> l = new ArrayList<Work>();
        for (int idx = 0; idx < list.size(); idx++) {
            Work w = list.get(idx);
            // idx �Ԗڂ̃��R�[�h��personID(�]�ƈ�ID)����pID �ƈ�v���邩 
            // �ǂ������m�F���� 
            if (w.getPersonID() == pID &&
                    !w.getEraseFlag())
                l.add(w);
        }
        return new WorkList(l, c_list);
    }
}