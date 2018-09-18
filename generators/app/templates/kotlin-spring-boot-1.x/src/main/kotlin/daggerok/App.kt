package daggerok

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

@Controller
class Page {

  @GetMapping("", "/")
  fun index(model: Model): String {
    model.addAttribute("message", "ololo trololo!")
    return "index"
  }
}

@RestController
@RequestMapping(produces = [APPLICATION_JSON_UTF8_VALUE])
class Resource {

  @GetMapping("/{name}")
  fun index(@PathVariable(required = false) name: String? = null) =
    mapOf("hello" to "${name ?: "world"}!")
}

@SpringBootApplication
class App

inline fun <reified T: Any> runApplication(vararg args: String) =
  SpringApplication.run(T::class.java, *args)

fun main(args: Array<String>) {
  runApplication<App>(*args)
}
