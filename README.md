Java valuate
========

![Visitors](https://visitor-badge.laobi.icu/badge?page_id=Peidon.Jaluate)
[![Publish](https://github.com/Peidon/Jaluate/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/Peidon/Jaluate/actions/workflows/maven-publish.yml)
![Maven Central Version](https://img.shields.io/maven-central/v/io.github.peidon/jaluate)

| For the Go version, see [the repository](https://github.com/Peidon/kit/blob/master/README.md#1-valuate). |
|----------------------------------------------------------------------------------------------------------|

An expression evaluator, supporting functions orchestration and execution of operator flow.


## Key Features

* Supports null, decimal numeral, boolean, string(bytes), list(array), map(struct), functions and variables expressions.
* Supports accessor, allowing field extraction from objects, value lookup from maps by key, and access by array index.
* Custom Java functions can be added easily.
* Requires minimum Java version 11.

[//]: # (* Parallel execution of operators and functions is optional.)

## Installation

| To include it in your Maven project, see [the package](https://github.com/Peidon/Jaluate/packages/3115718) |
|------------------------------------------------------------------------------------------------------------|

Just add the dependency to your pom.xml

## Examples

Create a new EvaluableExpression, then call "Eval" on it.

```java
var expr = new EvaluableExpression("1 + 2 > 2.5");
var result = expr.Eval();
// result is now set to "true", the Boolean value.
```

How about with parameters and some math?

```java
var expr = new EvaluableExpression("(requests_made * requests_succeeded / 100) >= 90");
Map<String, Object> params = Map.of("requests_made", 100, "requests_succeeded", 80);
var result = expr.Eval(params);
// result is now set to "false", the Boolean value.
```

Or maybe you want to check the status of an alive check ("smoke test") page, which will be a string?

```java
var expr = new EvaluableExpression("http_response_body == \"service is ok\"");
Map<String, Object> params = Map.of("http_response_body", "service is ok");
var result = expr.Eval(params);
// result is now set to "true", the Boolean value.
```

What if return numeric ones?

```java
var expr = new EvaluableExpression("100 * (mem_used / total_mem)");
Map<String, Object> params = Map.of("total_mem",1024, "mem_used", 512);
var result = expr.Eval(params);
// result is now set to "50.0", the Double value.
```

What operators and types does it support?
--

* Modifiers: `+` `-` `/` `*`
* Comparators: `>` `>=` `<` `<=` `==` `!=`
* Logical ops: `||` `&&`
* Numeric constants, as decimal fraction (`12345.678`), as decimal int (`123`)
* String constants (double quotes: `"foobar"`)
* Short bytes ASCII constants (single quotes: `'abc'`)
* Long bytes Unicode constants (`'''hello world'''`, or `"""hello world"""`)
* Boolean constants: `true` `false`
* Null constants: `null`
* Parenthesis to control order of evaluation `(` `)`
* Arrays (anything separated by `,` within parenthesis: `[1, 2, 3]`)
* Map (string as key, any type as value: `{'high' : 10, 'width' : 20.0}`)
* Prefixes: `!` `-`

Functions
--

You may have cases where you want to call a function on a parameter during execution of the expression. 
Perhaps you have a mathematical operation you want to perform, like `log` or `tan` or `sqrt`. 
For cases like this, you can provide a map of functions which will then be used during expression execution. 
For instance:

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
    // Globally initialize the functions for all expressions
    Constant.initfunctions(functions);

    // Use functions in expressions
    var expr = new EvaluableExpression("sqrt(4.0)");
    var result = expr.Eval();
    // result is now set to "2.0", the Double value.
    var expr = new EvaluableExpression("log(exp(3.0))");
    var result = expr.Eval();
    // result is now set to "3.0", the Double value.
}
```

Functions can accept most 4 arguments (following the universal coding discipline), correctly handles nested functions, 
and arguments can be of any type (even if none of this library's operators support evaluation of that type). 
For instance, each of these usages of functions in an expression are valid 
(assuming that the appropriate functions and parameters are given):

```text
"max(someValue, abs(anotherValue), 10 * lastValue, x1 + x2)"
```

Accessors
--

If you have structs(map or object) in your parameters, you can access their fields in the usual way. 
For instance, given a struct that has a field "bar", present in the parameters as `foo`, the following is valid:

	"foo.bar"

Assuming `foo` has a field called "Size":

	"foo.Size > 9000"

Accessors can be nested to any depth, like the following:

	"foo.Bar.Baz.Length"

Assuming `foo.bar.Baz` is an `array` or a `slice`:

	"foo.bar.Baz[0]"

You can access the element with an index parameter, Assuming `idx` is an integer:

    "foo.bar.Baz[idx]"

It will return error when the field not exists or index out of range.

Escaping characters
--

Sometimes you'll have parameters that have spaces, slashes, pluses, ampersands or some other character
that this library interprets as something special. For example, the following expression will not
act as one might expect:

	"response.time < 100"

As written, the library will parse it as "[response] dot [time] is less than 100". In reality,
"response.time" is meant to be one variable that just happens to have a dot in it.

There are two ways to work around this. First, you can escape the entire parameter name:

 	"${response.time} < 100"

Or you can give one more parameter named "response" which is a struct has field "time".