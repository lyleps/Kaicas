JAVAX = javac
SRCDIR = src/
BLDDIR = target/

FLS = Lexer

$(BLDDIR)Lexer.class: $(SRCDIR)Lexer.java
	$(JAVAX) -sourcepath $(SRCDIR) -d $(BLDDIR) Lexer.java
