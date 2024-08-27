- Model: Defines the `Supplier` entity.
- Repository: Manages interactions with the database for `Supplier` entities.
- Service: Contains the logic for searching suppliers.
  Controller: Handles HTTP requests and responses for the API.
Setup
What You Need

- Java 17 or later
- Maven
- Spring Boot
Getting Started

1. Clone the Repository

   First, clone the project repository:

   ```bash
   git clone https://github.com/yourusername/your-repository.git
   cd your-repository
   ```

2. Build the Project

   Next, build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Run the Application

   Start the application with:

   ```bash
   mvn spring-boot:run
   ```

   Your API will be up and running at `http://localhost:8080`.

API Endpoints

Search Suppliers

Endpoint:

`POST /api/supplier/query`

What It Does:

This endpoint retrieves a list of suppliers based on location, nature of business, and manufacturing processes. You can also paginate through the results.

Parameters:

- `location` (optional): Filter by supplier location.
- `natureOfBusiness` (optional): Filter by nature of business.
- `manufacturingProcess` (optional): Filter by manufacturing process.
- `page` (optional, default: 0): Page number for pagination.
- `size` (optional, default: 10): Number of suppliers per page.

How to Make a Request:

To search for suppliers, send a POST request to:


POST http://localhost:8080/api/supplier/query?location=India&natureOfBusiness=small_scale&manufacturingProcess=3d_printing&page=0&size=10


Request Body:

If you’re using a JSON body (alternative implementation), it looks like this:

```json
{
  "location": "India",
  "natureOfBusiness": "small_scale",
  "manufacturingProcess": "3d_printing",
  "page": 0,
  "size": 10
}
```

Response:

You’ll get a paginated list of suppliers that match your criteria. Here’s an example of what the response might look like:

```json
{
  "content": [
    {
      "supplierId": 1,
      "companyName": "Example Company",
      "website": "http://example.com",
      "location": "India",
      "natureOfBusiness": "small_scale",
      "manufacturingProcesses": ["3d_printing"]
    }
  ],
  "pageable": {
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 10,
    "unpaged": false,
    "paged": true
  },
  "totalElements": 1,
  "totalPages": 1,
  "size": 10,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "numberOfElements": 1,
  "first": true,
  "last": true,
  "empty": false
}


Error Handling:

If something goes wrong, you might get a `400 Bad Request` error. For example:

json
{
    "timestamp": "2024-08-27T09:47:04.777+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/api/supplier/query"
}


Testing

To test the API, you can use tools like Postman or `curl`. For unit tests, you can use JUnit along with Spring Boot Test. Here’s a basic unit test example:

java
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceTests {

    @Autowired
    private SupplierService supplierService;

    @Test
    public void testSearchSuppliers() {
        Page<Supplier> result = supplierService.searchSuppliers("India", "small_scale", "3d_printing", PageRequest.of(0, 10));
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}


Documentation

For more details, check out the inline comments in the code or any Swagger documentation if it’s set up.



Note: Make sure to replace `https://github.com/yourusername/your-repository.git` with your actual repository URL. Adjust the testing and documentation sections as necessary based on your setup.
