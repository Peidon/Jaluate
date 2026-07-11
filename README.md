# Jaluate - Java valuate  


![Visitors](https://visitor-badge.laobi.icu/badge?page_id=Peidon.Jaluate)
[![Publish](https://github.com/Peidon/Jaluate/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/Peidon/Jaluate/actions/workflows/maven-publish.yml)
![Maven Central Version](https://img.shields.io/maven-central/v/io.github.peidon/jaluate)

| For the Go version, see [the repository](https://github.com/Peidon/kit/blob/master/README.md#1-valuate). |
|----------------------------------------------------------------------------------------------------------|


A lightweight and extensible expression evaluator, supporting function orchestration, and operator flow execution.

## Key Features

* Supports functions expressions.
* Supports field accessors:

    * Object field extraction
    * Map value lookup by key
    * Array indexing
* Easily extensible with custom Java functions.

<!-- Parallel execution of operators and functions is planned for future releases. -->


## Installation

Add the dependency to your `pom.xml`.

| For Maven coordinates and published artifacts, see [the package](https://github.com/Peidon/Jaluate/packages/3115718) |
|----------------------------------------------------------------------------------------------------------------------|

Requires **Java 11** or later.

## Quick Start

Create an `EvaluableExpression` and call `Eval()` to execute it.

### Boolean Expression

```java
var expr = new EvaluableExpression("1 + 2 > 2.5");
var result = expr.Eval();
// result == true
```

### Expressions with Parameters

```java
var expr = new EvaluableExpression(
        "(requests_made * requests_succeeded / 100) >= 90"
);

Map<String, Object> params = Map.of(
        "requests_made", 100,
        "requests_succeeded", 80
);

var result = expr.Eval(params);
// result == false
```

### String Comparison

```java
var expr = new EvaluableExpression(
        "http_response_body == \"service is ok\""
);

Map<String, Object> params = Map.of(
        "http_response_body", "service is ok"
);

var result = expr.Eval(params);
// result == true
```

### Numeric Calculation

```java
var expr = new EvaluableExpression(
        "100 * (mem_used / total_mem)"
);

Map<String, Object> params = Map.of(
        "total_mem", 1024,
        "mem_used", 512
);

var result = expr.Eval(params);
// result == 50.0
```


## Supported Operators and Types

### Arithmetic Operators

| `+`      | `-`         | `*`            | `/`      | `%`    |
|----------|-------------|----------------|----------|--------|
| Addition | Subtraction | Multiplication | Division | Modulo |

### Comparison Operators

| `>`          | `>=`                  | `<`       | `<=`               | `==`  | `!=`      |
|--------------|-----------------------|-----------|--------------------|-------|-----------|
| Greater than | Greater than or equal | Less than | Less than or equal | Equal | Not equal |

### Logical Operators

| `&&`        | `\|\|`     |
|-------------|------------|
| Logical AND | Logical OR |

### Prefix Operators

| `!`         | `-`            |
|-------------|----------------|
| Logical NOT | Unary negative |

### Supported Constants

* Integer numbers: `123`
* Decimal numbers: `12345.678`
* Strings: `"hello world"`
* ASCII byte strings: `'abc'`
* Unicode byte strings: `'''hello world'''` or `"""hello world"""`
* Boolean values: `true`, `false`
* Null value: `null`

### Collections

#### Arrays

Anything separated by `,` within parenthesis.

```text
[1, 2.0, 'a', "b", some_struct, f(), a+b]
```

#### Maps

String as key, any type as value.

```text
{"height": 10, 'width': 20.0, 'content': {"data": """hello world ...""", 'summary': "abc..."}}
```

### Parentheses

Use parentheses to control evaluation order:

```text
(1 + 2) * 3
```


## Functions

Jaluate supports custom function registration during expression evaluation.

This allows users to embed domain-specific logic directly into expressions.

For example:

```java
import org.xpd.EvaluableExpression;
import org.xpd.operator.FunctionalOperator;
import org.xpd.core.Constant;

void main() {

    var functions = Map.of(
            "log", new FunctionalOperator<>(Math::log),
            "exp", new FunctionalOperator<>(Math::exp),
            "sqrt", new FunctionalOperator<>(Math::sqrt)
    );

    // Register functions globally
    Constant.initfunctions(functions);

    var expr1 = new EvaluableExpression("sqrt(4.0)");
    var result1 = expr1.Eval();
    // result1 == 2.0

    var expr2 = new EvaluableExpression("log(exp(3.0))");
    var result2 = expr2.Eval();
    // result2 == 3.0
}
```

Functions support:

* Up to **4 arguments** ( following universal coding discipline )
* Nested function calls
* Parameters of any type

Example:

```text
select_maximum(
    someValue,
    abs(anotherValue),
    10 * lastValue,
    x1 + x2
)
```


## Accessors

Jaluate supports accessing fields from objects and maps using familiar dot notation.

If `foo` contains a field called `Size`:

```text
foo.Size > 9000
```

Nested accessors are fully supported:

```text
foo.Bar.Baz.Length
```

Array indexing is also supported:

```text
foo.bar.Baz[0]
```

Index expressions are allowed:

```text
foo.bar.Baz[idx]
```

The evaluator returns an error when:

* the field does not exist
* the index is out of bounds


## Escaping Variable Names

Sometimes variable names contain characters that are normally interpreted as operators or accessors.

For example:

```text
response.time < 100
```

By default, this expression is interpreted as:

```text
response.time
```

meaning:

```text
response -> field time
```

However, if `response.time` is actually a single variable name, you can escape it using `${}` syntax:

```text
${response.time} < 100
```

Alternatively, you can pass a parameter called `response` containing a field named `time`.


## Use Cases

Jaluate is particularly suitable for:

* Business rule engines
* Workflow orchestration
* Dynamic configuration systems
* Feature flags
* Alerting and monitoring systems
* Decision engines
* Domain Specific Languages (DSLs)


## License

Please refer to the project repository for licensing information.