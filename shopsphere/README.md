# 🛒 ShopSphere

A lightweight, console-based shopping application built in **Java**. Browse a product catalog, search for items, manage a shopping cart and check out, all from the terminal. No external libraries or build tools required.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Type](https://img.shields.io/badge/type-console%20app-blue)
![Dependencies](https://img.shields.io/badge/dependencies-none-brightgreen)

## ✨ Features

- **Browse products** across categories (Electronics, Stationery, Accessories)
- **Search** by product name or category
- **Cart management**: add items, remove items, view a running total
- **Stock validation**: you can't add more than what is available
- **Checkout** with confirmation, which updates inventory after a successful order
- **Input validation** for invalid menu choices and non-numeric input

## 🧰 Tech Stack

- Java 17+ (uses switch expressions and streams)
- Standard library only, with no Maven, Gradle or external dependencies

## 📁 Project Structure

```
ShopSphere/
├── README.md
└── src/
    └── com/shopsphere/
        ├── Main.java              # Console menu and application entry point
        ├── model/
        │   ├── Product.java       # Product data and stock handling
        │   └── CartItem.java      # A product and quantity inside the cart
        └── service/
            ├── Catalog.java       # Product listing, lookup and search
            └── Cart.java          # Cart logic: add, remove, total, clear
```

## 🚀 Getting Started

### Prerequisites

- JDK 17 or newer. Check with:
  ```
  java -version
  javac -version
  ```
  Download from [adoptium.net](https://adoptium.net) if needed.

### Clone the repository

```
git clone https://github.com/<your-username>/ShopSphere.git
cd ShopSphere
```

### Build and run

**Windows (PowerShell)**
```powershell
mkdir out
javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out com.shopsphere.Main
```

**macOS / Linux**
```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out com.shopsphere.Main
```

### Using an IDE

- **IntelliJ IDEA**: File → New → Project from Existing Sources, select the folder, mark `src` as the sources root, then run `Main.java`.
- **VS Code**: install the *Extension Pack for Java*, open the folder and click **Run** above `main` in `Main.java`.

## 🖥️ Usage

When the app starts you'll see this menu:

```
=== Welcome to ShopSphere ===

1. Browse products
2. Search products
3. Add to cart
4. View cart
5. Remove from cart
6. Checkout
0. Exit
```

Type the number of an option and press Enter. A typical session:

1. `1`: list all products and note their IDs
2. `3`: enter a product ID and a quantity to add it to your cart
3. `4`: review your cart and total
4. `6`: checkout, then confirm with `y`

## 🗺️ Roadmap

- [ ] Persist the catalog and orders to a file or database
- [ ] User accounts and login
- [ ] Discount codes and tax calculation
- [ ] Order history
- [ ] Graphical interface (Swing or JavaFX)
- [ ] Unit tests with JUnit

## 🤝 Contributing

Contributions are welcome. Fork the repo, create a feature branch, commit your changes and open a pull request.

## 📄 License

This project is licensed under the MIT License. Add a `LICENSE` file to the repository root (on GitHub: **Add file → Create new file → name it `LICENSE`**, then pick the MIT template).
