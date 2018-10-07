# KAICAS
Kaicas An Interpreted Computer Algebraic System.   
Or, KAIC   
Kaic's An Interperted CAS   

# Project Goal
To create a functioning CAS (Computer Algebraic System) with a unique
language in Java.

# Why Java?
Java will be used for cross platform compatibility reasons. In
addition the Java has some nice built in functionalities such as
garbage collection.

# Project Stages
## I.
Create an interpreted functional language to for which all
additional functionalities of Kaicas are based on. This will
be a functional language for ease of developing. See the
Functional Language Specifications below.

### i.
Design the specifications for the functional language. This should
also include specifications for higher level structures and
function used in the CAS part of the program since they must work
well together. 

### ii.
Create a lexical analyzer that reads input from a text file or
command line / terminal input. 

### iii.
Implement the base structure for storing symbols

### iv.
Implement global variable list.

### v.
Implement rudimentary functions.

### vi.
Implement definition function and global function list.

## II.
Implement integral functionalities to Kaicas such as factoring,
expanding, limits, derivatives, integrals, etc. 

## III.
Develop a infix to prefix translator for the language. See Infix
Language Specifications below. 

## IV.
Create a GUI for language

# Functional Language Specifications
This language is white space delimited
It's functional so it reads like most lisp

## Tokens
### Special Characters
- ()  
- (  
- )  
- ==  
- <  
- />  
- <=  
- \>=  
- &&  
- ||  
- !  
- .  
- ,  
- \+  
- \-  
- \*  

### Names
Names must start with either an upper case or lower case letter or
a sharp. They can contain alphanumerics, underscores 

#### Examples
- alpha  
- Alpha  
- beta_1  
- DeLtA1A_2  
- \#e  
- \#pi  

### Numbers
Numbers must start with an alphanumeric. They can contain
underscores and dots. Note that underscores are for ease of
reading and do not have an affect on the value of the number. Dots
allow the user to input numbers in a decimal system. Numbers can
not contain more than one dot. Numbers with a dot will be stored
as a float.

#### Examples
- 1  
- 2  
- 1_000  
- 21_260  
- 21_260.375  

# Infix Language Specifications
TODO: CREATE SPECIFICATIONS BEFORE STARTING TO CODE!!!
