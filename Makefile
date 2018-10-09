JAVAX = javac
XFLAGS = -Xlint:deprecation

SRCDIR = src/
BLDDIR = target/
DOCDIR = docs/

FLS = Lexer
CLSFLS = $(addprefix $(BLDDIR), $(addsuffix .class, $(FLS)))
DOCFLS = $(addprefix $(DOCDIR), $(addsuffix .html, $(FLS)))

$(CLSFLS): $(BLDDIR)%.class: $(SRCDIR)%.java
	@echo Building $@ from $<
	$(JAVAX) -d $(BLDDIR) -sourcepath ./ $(XFLAGS) $^


docs: $(DOCFLS)

$(DOCFLS): $(DOCDIR)%.html: $(SRCDIR)%.java
	javadoc -d $(DOCDIR) $<

clean:
	rm -rf **/*.class **/*~ $(DOCDIR)*
