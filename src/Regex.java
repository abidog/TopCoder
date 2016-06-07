public class Regex {

    public String replaceDuplicates(String line) {
        return line.replaceAll("(.)\\1+", "$1");
    }

}
