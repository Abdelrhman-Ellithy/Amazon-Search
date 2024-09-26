# Amazon-Search

A simple task for searching an item, retrieving the results (names and prices), and writing them into an Excel file using the **Ellithium** framework.

## Features:
- Search for items on a page.
- Retrieve the names and prices of search results.
- Write the retrieved data (item names and prices) to an Excel file, including automatic file creation if the file doesn't exist.
- Detailed logging and reporting using Ellithium utilities for logging and Excel file handling.

## Project Structure:
```text
.
├── src
│   ├── main
│   └── test
│       ├── java
│       │   ├── stepDefinitions
│       │   ├── Base
│       │   ├── Pages
│       │   └── Ellithium
│       │       └── Utilities
│       │           └── ExcelHelper.java
│       └── resources
│           └── TestData
│               └── Scope Assessment1.xlsx
├── pom.xml
└── README.md
```

## Prerequisites:
- Java 21
- Apache Maven
- Ellithium Framework

### Maven Dependencies:
You only need to include the **Ellithium** dependency for your project. Below is the `pom.xml` configuration:

```xml
<dependencies>
    <!-- Ellithium Framework Dependency -->
    <dependency>
        <groupId>io.github</groupId>
        <artifactId>Ellithium</artifactId>
        <version>1.0.2</version>
    </dependency>

    <!-- Rest Assured (Optional, if required for API testing) -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>${restversion}</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## How It Works:

### Step Definitions:
The core logic resides in the `SearchStepDefinition` class, where we simulate searching for an item, retrieving the results, and writing them to an Excel file.

```java
@Then("relevant items are returned")
public void relevant_items_are_returned() {
    List<String> itemNames = searchPage.getResultsNames();
    List<String> itemPrices = searchPage.getResultsPrices();
    List<Map<String, String>> data = new ArrayList<>();

    // Collecting names and prices into a map
    for (int i = 0; i < Math.min(itemNames.size(), itemPrices.size()); i++) {
        Map<String, String> entry = new HashMap<>();
        entry.put("Item Name", itemNames.get(i));
        entry.put("Item Price", itemPrices.get(i));
        data.add(entry);
    }

    // Logging and writing the data to an Excel file using Ellithium's ExcelHelper
    System.out.println(data);
    ExcelHelper.setExcelData("src/test/resources/TestData/Scope Assessment1", "ItemsAndPrices", data);
}
```

### Excel Helper:
The `ExcelHelper` class, part of the Ellithium framework, is responsible for handling all Excel-related operations. It supports reading from and writing to `.xlsx` files, automatically creating the file if it does not exist.

```java
// Writing data into Excel and handling creation of new files if necessary
public static void setExcelData(String filePath, String sheetName, List<Map<String, String>> data) {
    // Logging and writing logic using Ellithium utilities
    // Automatically creates file if it doesn't exist
    ...
}
```

### Key Functionalities:
- **File creation**: Automatically creates the Excel file if it doesn't exist.
- **Sheet handling**: If the target sheet doesn’t exist, it is created.
- **Logging**: Uses Ellithium’s logging utilities for detailed debugging and tracking of each operation.

## Running the Tests:
1. Navigate to the project root.
2. Use Maven to run the tests:
   ```bash
   mvn clean test
   ```

3. The results and logs will be available in the generated Excel file under `src/test/resources/TestData/Scope Assessment1.xlsx`.

4. **Allure Reporting**: You can integrate Allure reporting using Ellithium's built-in logging and reporting utilities.

## Conclusion:
This project demonstrates the use of Ellithium for automating a search operation, handling Excel files, and providing detailed logging and reporting with minimal configuration.
