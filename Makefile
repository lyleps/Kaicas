JAVAX = javac
XFLAGS = -Xlint:deprecation

SRCDIR = src/
BLDDIR = target/
DOCDIR = docs/

FLS = Lexer Parser Runner Cell Eval GAL
CLSFLS = $(addprefix $(BLDDIR), $(addsuffix .class, $(FLS)))
DOCFLS = $(addprefix $(DOCDIR), $(addsuffix .html, $(FLS)))
SRCFLS = $(addprefix $(SRCDIR), $(addsuffix .java, $(FLS)))
RM = rm -rf

all: $(CLSFLS) $(DOCFLS)

program: $(CLSFLS)

docs: $(DOCFLS)

$(CLSFLS): $(SRCFLS)
	$(JAVAX) -d $(BLDDIR) $(XFLAGS) $(SRCFLS)

$(DOCFLS): $(SRCFLS)
	javadoc -html5 -d $(DOCDIR) $(SRCFLS)

clean:
	$(RM) **/*.class **/*~ $(DOCDIR)*
