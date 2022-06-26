BF-GRAAL
=======
A brainfuck interpreter written on top of Truffle to run on the GraalVM

**Requires Graal VM version `22.1.0.1`**

To Build
--------

```bash
mvn package
```

To Run
------

```bash
JAVA_HOME=/path/to/graal/vm ./bf examples/hello-world.bf
```
