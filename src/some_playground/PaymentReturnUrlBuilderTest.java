package some_playground;


public class PaymentReturnUrlBuilderTest {
    private final static String HTTPS_SCHEME = "https";
    private final static String HTTP_SCHEME = "http";

    public static void main(String[] args) {
        String mockUrl = "http://www.javatpoint.com/java-string-replaceall";
        mockUrl = mockUrl.replaceAll(HTTP_SCHEME, HTTPS_SCHEME);
        System.out.println(mockUrl);

    }


}
