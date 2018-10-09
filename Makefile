JAVAX = javac
SRCDIR = src/
BLDDIR = target/
DOCDIR = docs/

FLS = Lexer
CLSFLS = $(addprefix $(BLDDIR), $(addsuffix .class, $(FLS)))
DOCFLS = $(addprefix $(DOCDIR), $(addsuffix .html, $(FLS)))

$(CLSFLS): $(BLDDIR)%.class: $(SRCDIR)%.java
	@echo Building $@ from $<
	$(JAVAX) -d $(BLDDIR) -sourcepath ./ -Xlint:deprecation $^


docs: $(DOCFLS)

$(DOCFLS): $(DOCDIR)%.html: $(SRCDIR)%.java
	javadoc -d $(DOCDIR) $<

clean:
	rm -rf **/*.class **/*~ $(DOCDIR)*
