public class DataFormatException extends Throwable {
    String s ;
    public DataFormatException(String s) {
        this.s=s;
    }

    @Override
    public String toString() {
        return "DataFormatException{" +
                "s='" + s + '\'' +
                '}';
    }
}
