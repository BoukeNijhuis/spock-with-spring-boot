package nl.cinqict

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class ApplicationTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    void "the application should return a hello"() {
        expect:
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Hello!"))
    }

    void "the application should return a hello but test in more Spocky way"() {
        when:
        def perform = mockMvc.perform(get("/"))
        then:
        perform.andExpect(status().isOk())
        perform.andExpect(content().string("Hello!"))

    }
}
