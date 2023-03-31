# HashingPuzzle
A little *puzzle* on using **multithreading** to force a **hash function**.

# The following problem is defined as a hashingpuzzle:
* Let S be an input string, Dun an integer and H a hashing algorithm.
* The goal is to identify a key K such that H(S+K) = T, where S+K is the concatenation between If Ke and T must start with Dzeri.

# Write a multithreaded application to solve the following puzzle:
* S= SisOp-Course A-Hashing-Puzzle-
* D= 7H
* The hashing algorithm to be used is SHA3- 256.
* The key K to be identified is a string of length between 1 and 6, which can contain only the characters of the following alphabet:
: ; < = > ? @ A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [\]

# Hint:
* The characters of the given alphabet are all consecutive...
* A char can be mapped to an integer...

# How to build
* The Java implementation of SHA3-256 to be used is the one provided by apache.commons.codec (a Maven project is required).
* To use the library, insert the following dependencies in the pom.xml file: