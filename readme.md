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
    .\mvnw spring-boot:run
    ```
    for test

    ```bash
    ./mvnw test
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

### Classes in Spring Boot

- A class is like a blueprint that describes how an object behaves. It can hold data (variables) and actions (methods).

- In Spring Boot, classes often represent services, controllers, or configurations.

- You create an object (an instance) of a class so you can use its methods. Spring does this for you automatically using @Component, @Service, @Controller etc.

- With Spring’s @Autowired, you don’t manually create objects. Spring sees your class annotated as a bean and automatically “injects” the object wherever you need it.

- In a class you can make variables or methods public, private, or static to control who can use them.

- You can still use @Override if you’re overriding a method from a parent class, but it’s optional (Java will still allow overriding without it, but the annotation helps catch mistakes).

### Interfaces in Spring Boot

- An interface is like a contract: it only lists method names (no actual code inside) that any class agreeing to the contract must implement.

- In Spring Boot, interfaces are often used for repositories (like JpaRepository) or service layers.

- Interfaces don’t create objects themselves. A class must implement the interface. Spring then creates the actual object (bean) of the implementing class automatically and injects it where needed with @Autowired.

- All methods in an interface are implicitly public and abstract (no body). You don’t need to write public every time.

- You cannot have instance variables in an interface (only constants static final).

- When a class implements an interface, you almost always use @Override on each method to show you’re implementing the interface’s contract.

- Interfaces themselves don’t use annotations like @Service directly, but the implementing class does.
### Looping in Spring Boot
- Spring Boot uses standard Java constructs for loops. You can use `for`, `while`, or `do-while` loops exactly as in plain Java.
- With Java 8, you can use the **Stream API** to loop through collections in a functional way (no explicit `for` loop).
- Example in theory: instead of a traditional loop to process a list, you call `list.stream().forEach(...)` to handle each item.

### Using Java 8 Lambdas in Spring Boot
- A **lambda** is a short way to write a function (no separate method needed).
- In Spring Boot you often use lambdas with:
  - **Streams**: `list.stream().filter(x -> x.isActive())`
  - **Callbacks**: for asynchronous or event-based code.
  - **Functional interfaces** like `Runnable`, `Consumer`, or custom interfaces.
- Lambdas make your code more concise and readable inside Spring Boot services or controllers.

### Conditional Logic (if-else) in Spring Boot
- You use `if`, `else if`, and `else` exactly like in Java.
- You can also use **ternary operators** for shorter conditions: `condition ? valueIfTrue : valueIfFalse`.
- In templates (like Thymeleaf) you can also write conditional expressions to show or hide UI parts, but it still follows the same Java-style logic.

### Handling Null Values with `Optional`
- `Optional` is a Java 8 class designed to represent a value that might be present or absent (null).
- Instead of returning `null`, methods return `Optional<T>`. This forces you to handle the absence explicitly.
- You can check:
  - `optional.isPresent()` or `optional.ifPresent(value -> ...)`
  - Provide a default: `optional.orElse(defaultValue)`
  - Provide a fallback action: `optional.orElseGet(() -> computeValue())`
  - Throw an exception if empty: `optional.orElseThrow()`
- In Spring Boot, you often see `Optional` used in repository queries to handle not-found database results safely.

### Array
- A fixed-size container that holds elements of the **same type** (e.g. `String[]`, `int[]`).
- Size must be known at creation; cannot grow or shrink.
- Best when you know the exact number of items and won’t change it.
- Example idea: an array of 7 days of the week.

### List
- An **interface** that represents an **ordered collection** of elements.
- Allows duplicates; preserves insertion order.
- You can add, remove, or access elements by index.
- Common implementations are `ArrayList` and `LinkedList`.

### ArrayList
- A resizable array implementation of `List`.
- Grows automatically as you add elements.
- Allows duplicates; preserves order.
- Fast for reading by index; slower for many insertions in the middle.
- Example idea: a dynamic list of students’ names.

### Set
- A collection that contains **no duplicate elements**.
- Order is not guaranteed (depends on implementation).
- Used when you only care about **uniqueness**.
- Common implementations: `HashSet` (no order), `LinkedHashSet` (insertion order), `TreeSet` (sorted order).
- Example idea: storing unique email addresses.

### Map
- A collection of **key–value pairs**.
- Each key maps to exactly one value; keys must be unique.
- Useful for lookups by a unique identifier.
- Common implementations: `HashMap` (no order), `LinkedHashMap` (insertion order), `TreeMap` (sorted by key).
- Example idea: mapping a student ID (key) to student details (value).

---

### Where to Use What
- **Array of strings / numbers** → use `String[]` or `int[]` if size fixed; use `ArrayList<String>` or `ArrayList<Integer>` if size changes.
- **Array of unique values** → use a `Set` (e.g. `HashSet<String>`).
- **Array of key–value pairs** → use a `Map` (e.g. `HashMap<String, Integer>`).
- **Need ordering + duplicates** → use `List` / `ArrayList`.
- **Need uniqueness only** → use `Set`.
- **Need fast key-based lookup** → use `Map`.



3. Implements vs Extends

extends = inherit code/behaviour from a class.
implements = promise to follow a contract/interface.

```bash
class Parent {}
class Child extends Parent {} // inherits Parent code

interface Doable { void doWork(); }
class Worker implements Doable { public void doWork(){} }

```
4. @Component + @Autowired
   @Component marks a class as a Spring bean.
   @Autowired tells Spring to inject a bean here.
   Together they wire dependencies automatically



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

11. @Service , @Controller and @Entity
    Marks a class as a service component (business logic layer) so Spring can auto-detect it and register it as a bean.

```bash
@Service
public class EmployeeService { /* business logic */ }

```

Marks a class as a Spring MVC controller to handle web requests and return views or responses.

```bash
@Controller
public class EmployeeController { /* request mappings */ }

```

Marks a class as a JPA entity that maps to a database table.

```bash
@Entity
public class Employee { /* fields map to columns */ }

```
