package de.telran.market.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.telran.market.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
//@ActiveProfiles({"test"})
class ProductControllerTest {

//  @Autowired
//  private ProductController productController;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ProductService productService;

  @Container
  private static MySQLContainer container = new MySQLContainer<>(
      DockerImageName.parse("mysql:latest"))
      .withDatabaseName("market")
      .withUsername("admin")
      .withPassword("admin");

  @DynamicPropertySource
  static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.password", container::getPassword);
    registry.add("spring.datasource.username", container::getUsername);
  }

  @Test
  @WithMockUser(username = "TEST_VASYA", roles = {"ADMIN"})
  void createProductTest() throws Exception {
//    productController.create()

    var request = """
          {
            "title": "swagger product",
            "description": "swagger product description",
            "price": 22.12
          }
        """;

//    var builder = post("/products")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(request);

//    mockMvc.perform(builder)
    mockMvc.perform(post("/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andExpect(status().isCreated())
        .andExpect(header().exists("test-header"))
        .andExpect(jsonPath("$.title").value("swagger product"))
        .andExpect(jsonPath("$.price").value(22.12));

    var createdProduct = productService.findById(1L);
    assertEquals("swagger product description", createdProduct.getDescription());
  }


}