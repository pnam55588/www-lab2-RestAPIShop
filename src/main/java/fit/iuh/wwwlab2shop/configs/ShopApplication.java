package fit.iuh.wwwlab2shop.configs;

//import fit.iuh.wwwlab2shop.resources.CustomerResource;
//import io.swagger.v3.jaxrs2.SwaggerSerializers;
//import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
//import io.swagger.v3.oas.integration.SwaggerConfiguration;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;


@ApplicationPath("/api")
public class ShopApplication extends Application {

//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> classes = new HashSet<>();
//
//        // Add your RESTful resource classes here
//        classes.add(CustomerResource.class);
//
//        // Register Swagger serializers for JSON output
//        classes.add(SwaggerSerializers.class);
//
//        return classes;
//    }
//
//    @Override
//    public Set<Object> getSingletons() {
//        // Initialize Swagger configuration
//        SwaggerConfiguration configuration = new SwaggerConfiguration()
//                .prettyPrint(true) // Enable pretty-printing of JSON
//                .resourcePackages(Collections.singleton("fit.iuh.wwwlab2shop.repositories")); // Set the package where your resources are located
//
//        // Build the Swagger context
//        return new JaxrsOpenApiContextBuilder()
//                .application(this)
//                .swaggerConfig(configuration)
//                .buildContext(true);
//    }
}
