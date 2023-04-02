# HashingPuzzle
A little *puzzle* on using **multithreading** to force a **hash function**.

## The following problem is defined as a hashing puzzle
* Let **S** be an input *string*, **D** un an *integer* and **H** a *hashing algorithm*.
* The goal is to identify a key **K** such that **H**(**S**+**K**) = **T**, where **S**+**K** is the *concatenation* between the two strings and **T** must start with **D** zeros.

## Write a multithreaded application to solve the following puzzle
* S = `SisOp-Course A-Hashing-Puzzle-`
* D = `7`
* The *hashing algorithm* to be used is `SHA3- 256`.
* The key **K** to be identified is a *string* of length between *1* and *6*, which can contain only the characters of the following alphabet:

`: ; < = > ? @ A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [ \ ]`

## Hint
* The characters of the given alphabet are all consecutive...
* A char can be mapped to an integer...

### Example
* **S** = `Esempio-Hashing-Puzzle-`
* **D** = *4*
* **K** = `=MZ`

**T** = **H**("Esempio-Hashing-Puzzle-*=MZ*") = ***0000***b5114f4f2da3eb004bf117eac13a1f02ccf459635de08d35457a40b3d515

---

#### Puzzle credit:
- *Prof.* **F. Marozzo**
- *Prof.* **R. Cantini**

***UNICAL University***, Calabria, Italy.