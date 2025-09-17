# Spring Boot App 🚀

## 📝 Prerequisites

1. **Install JDK** (Java Development Kit 17 or later)
   set path in env variable

2. **Install Maven**
   set path in env variable

3. **Verify Installations**
   ```bash
   java -version
   mvn -v
   ```
4. **Install VS Code Extensions**
   Extension Pack for Java
   Spring Boot Extension Pack
   thunder client

5. **Set up inside VS Code**
   ctrl+shift+p in vs code and select or go to spring initializer https://start.spring.io/ and generate
   ```bash
   spring Initializer: create a maven project
   ```

## Running the app

    ```bash
    .\mvnw spring-boot:run  or
    mvn spring-boot:run
    ```
    and go to http://localhost:8080/

## 📝 Concepts

1. IoC (Inversion of Control)
   Spring creates & manages objects (beans) for you instead of you doing new.
2. Dependency Injection (DI)
   Spring injects required objects into your classes automatically.

```bash
@Component
class MyService {}

@RestController
class MyController {
  @Autowired
  private MyService service; // injected by Spring
}
```

3. @Component + @Autowired
   @Component marks a class as a Spring bean.
   @Autowired tells Spring to inject a bean here.
   Together they wire dependencies automatically

4. Implements vs Extends

extends = inherit code/behaviour from a class.
implements = promise to follow a contract/interface.

```bash
class Parent {}
class Child extends Parent {} // inherits Parent code

interface Doable { void doWork(); }
class Worker implements Doable { public void doWork(){} }

```

5. Beans

Objects created and managed by Spring’s IoC container.
Any class annotated with @Component, @Service, @Repository, or defined in a config becomes a bean.

6. @RequestMapping vs @GetMapping

@RequestMapping = generic, supports GET/POST/PUT/DELETE.
@GetMapping = shortcut for GET only.

```bash
@GetMapping("/products")
public List<Product> getAll() { … }

```

```bash
@RequestMapping(value="/products", method=RequestMethod.POST)
public void addProduct() { … }

```

7. @PathVariable
   Extracts a value from the URL path.

```bash
@GetMapping("/products/{prodId}")
public Product getOne(@PathVariable int prodId){ … }

```

8. @RequestBody

Takes JSON body from the request and binds to an object.

```bash
@PostMapping("/products")
public Product add(@RequestBody Product p){ … }

```

9. ORM (Object Relational Mapping)

Maps Java objects ↔ database tables automatically (no manual SQL).

10. Looping

```bash
List<Product> products = new ArrayList<>();
List<Product> filtered = new ArrayList<>();
products.add(new Product(1, "Laptop", 55000));
products.add(new Product(2, "Phone", 25000));
products.add(new Product(3, "Mouse", 500));



for (int i = 0; i < products.size(); i++) {
    System.out.println(
        "ID: " + products.get(i).getId() +
        ", Name: " + products.get(i).getProdName() +
        ", Price: " + products.get(i).getPrice()
    );
    Product p = products.get(i);
    if (p.getPrice() > 1000) { // condition
        filtered.add(p);
    }

}

```

```bash
List<String> names = new ArrayList<>();
names.add("Apple");
names.add("Banana");
names.add("Avocado");

List<String> filteredNames = new ArrayList<>();
for (int i = 0; i < names.size(); i++) {
    if (names.get(i).startsWith("A")) {
        filteredNames.add(names.get(i));
    }
}

```
