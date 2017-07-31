package Print;
public interface Print {
    public void drawOnTerminal(byte[] content);
    public void drawOnFile(byte[] content,String fileName);
    public byte[] shape(char mark, int size);
}