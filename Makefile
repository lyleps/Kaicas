JAVAX = javac
XFLAGS = -Xlint:deprecation

SRCDIR = src/
BLDDIR = target/
DOCDIR = docs/

FLS = Lexer Parser Runner
CLSFLS = $(addprefix $(BLDDIR), $(addsuffix .class, $(FLS)))
DOCFLS = $(addprefix $(DOCDIR), $(addsuffix .html, $(FLS)))
SRCFLS = $(addprefix $(SRCDIR), $(addsuffix .java, $(FLS)))

all: $(CLSFLS) $(DOCFLS)

program: $(CLSFLS)

docs: $(DOCFLS)

$(CLSFLS): $(SRCFLS)
	$(JAVAX) -d $(BLDDIR) $(XFLAGS) $(SRCFLS)

$(DOCFLS): $(SRCFLS)
	javadoc -d $(DOCDIR) $(SRCFLS)

clean:
	rm -rf **/*.class **/*~ $(DOCDIR)*
