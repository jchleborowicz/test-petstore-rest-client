package pl.jch.test.rest;

import java.util.Collections;
import java.util.List;

import com.petstore.api.PetApi;
import com.petstore.api.invoker.ApiClient;
import com.petstore.api.model.Pet;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestClientException;


public class PetStoreClient {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        final ApiClient defaultClient = applicationContext.getBean(ApiClient.class);

        // Configure OAuth2 access token for authorization: petstore_auth
//        OAuth petstore_auth = (OAuth) defaultClient.getAuthentication("petstore_auth");
//        petstore_auth.setAccessToken("YOUR ACCESS TOKEN");

        final PetApi apiInstance = new PetApi(defaultClient);
        final Pet body = new Pet(); // Pet | Pet object that needs to be added to the store
        try {
            final List<Pet> petsByStatus =
                    apiInstance.findPetsByStatus(Collections.singletonList(Pet.StatusEnum.AVAILABLE.getValue()));
            petsByStatus.stream()
                    .map(p -> p.getId() + " " + p.getName())
                    .forEach(System.out::println);
        } catch (final RestClientException e) {
            System.err.println("Exception when calling PetApi#addPet");
//            System.err.println("Status code: " + e.getCode());
//            System.err.println("Reason: " + e.getResponseBody());
//            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
