/* RecordList.java 
*/
/* RecordList 
*/
interface RecordList {
    // ���ۃ��\�b�h 
    /** add 
    * �������e�F���R�[�h��ǉ����� 
    * @param String data 
    * @throws Exception 
    */
    public abstract void add(String data) throws Exception;

    // ���ۃ��\�b�h 
    /** getRecord 
    * �������e�F�w��C���f�b�N�X�̃��R�[�h���擾���� 
    * @param int idx 
    * @return Record 
    */
    public abstract Record getRecord(int idx);

    // ���ۃ��\�b�h 
    /** size 
    * �������e�F���R�[�h�������擾���� 
    * @return int 
    */
    public abstract int size();
}