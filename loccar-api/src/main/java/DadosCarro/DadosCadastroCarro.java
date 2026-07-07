package DadosCarro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCarro(

        @NotBlank
        String marca,

        @NotBlank
        String modelo,

        @NotNull
        Integer ano,

        @NotNull
        @Pattern(regexp = "[A-Z]{3}[0-9][A-Z0-9][0-9]{2}", message = "Formato da placa inválido")
        String placa) {
}
