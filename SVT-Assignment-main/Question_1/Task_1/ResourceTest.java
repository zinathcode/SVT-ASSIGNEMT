import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class ResourceTest {

    static List<String> sharedResource;
    List<String> testResource;

    @BeforeAll
    static void setUpSharedResources() {
        // Initialize shared resources before all tests
        
        sharedResource = new ArrayList<>();
        System.out.println("@BeforeAll - Shared resources initialized");
    }

    @BeforeEach
    void setupTestResources() {
        // Initialize test-specific resources before each test
        testResource = new ArrayList<>();
        System.out.println("@BeforeEach - Test resources initialized");
    }

    @Test
    void testAddElement() {
        System.out.println("Running testAddElement");
        testResource.add("Element1");
        Assertions.assertEquals(1, testResource.size());
    }

    @Test
    void testSharedResource() {
        System.out.println("Running testSharedResource");
        sharedResource.add("SharedElement");
        Assertions.assertFalse(sharedResource.isEmpty());
    }

    @AfterEach
    void cleanupTestResources() {
        // Clean up test-specific resources after each test
        testResource.clear();
        System.out.println("@AfterEach - Test resources cleaned up");
    }

    @AfterAll
    static void cleanupSharedResources() {
        // Clean up shared resources after all tests
        sharedResource.clear();
        System.out.println("@AfterAll - Shared resources cleaned up");
    }
}
