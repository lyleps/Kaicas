JAVAX = javac
XFLAGS = -Xlint:deprecation

SRCDIR = src/
BLDDIR = target/
DOCDIR = docs/

FLS = Lexer Parser Runner
CLSFLS = $(addprefix $(BLDDIR), $(addsuffix .class, $(FLS)))
DOCFLS = $(addprefix $(DOCDIR), $(addsuffix .html, $(FLS)))

project: $(CLSFLS)

$(CLSFLS): $(BLDDIR)%.class: $(SRCDIR)%.java
	@echo $(CLSFLS)
	@echo Building $@ from $<
	$(JAVAX) -d $(BLDDIR) -sourcepath $(SRCDIR) $(XFLAGS) $^


docs: $(DOCFLS)

$(DOCFLS): $(DOCDIR)%.html: $(SRCDIR)%.java
	javadoc -d $(DOCDIR) $<

clean:
	rm -rf **/*.class **/*~ $(DOCDIR)*
