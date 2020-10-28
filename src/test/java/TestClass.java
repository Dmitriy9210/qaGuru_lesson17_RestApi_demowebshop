import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {

    @Test
    void addToChart() {

        Response response = given()
                .cookie("Nop.customer=be78e3cb-1641-44c3-92e1-338ac760ee2d; ARRAffinity=27a67e33786f8ab23a30ad511ae8eba575b52d88316f57912aa47193a6f9d384; __utmc=78382081; __utmz=78382081.1603865248.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2;")
//                .body(data)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/13/1")
                .then()
//                .statusCode(200)
                .log().body()
                .extract()
                .response();

        boolean aaa = response.path("success");
        assertTrue(aaa, response.asString());
    }

    @Test
    void updateChart() {
        given()
//                .cookie("Nop.customer=be78e3cb-1641-44c3-92e1-338ac760ee2d; ARRAffinity=27a67e33786f8ab23a30ad511ae8eba575b52d88316f57912aa47193a6f9d384; __utmc=78382081; __utmz=78382081.1603865248.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2; __utma=78382081.1832277462.1603865248.1603865248.1603874350.2; __atuvc=6%7C44; __atuvs=5f992e2a7b33125f002; __utmb=78382081.16.10.1603874350")
                .cookie("Nop.customer=be78e3cb-1641-44c3-92e1-338ac760ee2d; ARRAffinity=27a67e33786f8ab23a30ad511ae8eba575b52d88316f57912aa47193a6f9d384; __utmc=78382081; __utmz=78382081.1603865248.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2; __utma=78382081.1832277462.1603865248.1603865248.1603874350.2; __atuvc=6%7C44; __atuvs=5f992e2a7b33125f002; __utmt=1; __utmb=78382081.33.10.1603874350")
                .contentType("multipart/form-data; boundary=----WebKitFormBoundaryn5XDxFuBNIYecXXm")
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .body("------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"removefromcart\"\n" +
                        "\n" +
                        "1492288\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"itemquantity1518328\"\n" +
                        "\n" +
                        "1\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"updatecart\"\n" +
                        "\n" +
                        "Update shopping cart\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"discountcouponcode\"\n" +
                        "\n" +
                        "\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"giftcardcouponcode\"\n" +
                        "\n" +
                        "\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"CountryId\"\n" +
                        "\n" +
                        "0\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"StateProvinceId\"\n" +
                        "\n" +
                        "0\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"ZipPostalCode\"\n" +
                        "\n" +
                        "\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm--\n")
                .when()
                .post("http://demowebshop.tricentis.com/cart")
                .then()
                .statusCode(200)
                .log().body().extract().response();
    }
}
