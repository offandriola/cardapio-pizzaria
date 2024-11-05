package com.example.pizzaria;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText qtdPizza1, qtdPizza2, qtdPizza3, qtdPizza4;
    TextView txtTotal, txtResultadoPedido;
    Button btnCalcularTotal, btnPedido;

    // Preços das pizzas
    double precoPizza1 = 30.00; // Pizza de Frango c/ Catupiry
    double precoPizza2 = 25.00; // Pizza de Calabresa
    double precoPizza3 = 22.00; // Pizza de Mussarela
    double precoPizza4 = 32.00; // Pizza de Marguerita

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Barra
        getWindow().setStatusBarColor(Color.parseColor("#D1D1D1"));
        getWindow().setNavigationBarColor(Color.parseColor("#D1D1D1"));

        // Referenciando os componentes do layout
        qtdPizza1 = findViewById(R.id.qtdPizza1);
        qtdPizza2 = findViewById(R.id.qtdPizza2);
        qtdPizza3 = findViewById(R.id.qtdPizza3);
        qtdPizza4 = findViewById(R.id.qtdPizza4);
        txtTotal = findViewById(R.id.txtTotal);
        txtResultadoPedido = findViewById(R.id.txtResultadoPedido);
        btnCalcularTotal = findViewById(R.id.btnCalcularTotal);
        btnPedido = findViewById(R.id.btnPedido);

        // Ação do botão para calcular o total
        btnCalcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });

        // Ação do botão para fazer o pedido (resumo)
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarResumoPedido();
            }
        });
    }

    // Método para calcular o total
    private void calcularTotal() {
        // Pega as quantidades inseridas ou define como 0 se o campo estiver vazio
        int quantidade1 = qtdPizza1.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza1.getText().toString());
        int quantidade2 = qtdPizza2.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza2.getText().toString());
        int quantidade3 = qtdPizza3.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza3.getText().toString());
        int quantidade4 = qtdPizza4.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza4.getText().toString());

        // Calcula o total multiplicando a quantidade pelo preço
        double total = (quantidade1 * precoPizza1) + (quantidade2 * precoPizza2) +
                (quantidade3 * precoPizza3) + (quantidade4 * precoPizza4);

        // Exibe o total formatado no TextView
        txtTotal.setText(String.format("Total: R$ %.2f", total));
    }

    // Método para mostrar o resumo do pedido
    private void mostrarResumoPedido() {
        // Pega as quantidades inseridas
        int quantidade1 = qtdPizza1.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza1.getText().toString());
        int quantidade2 = qtdPizza2.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza2.getText().toString());
        int quantidade3 = qtdPizza3.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza3.getText().toString());
        int quantidade4 = qtdPizza4.getText().toString().isEmpty() ? 0 : Integer.parseInt(qtdPizza4.getText().toString());

        // Monta o resumo do pedido
        StringBuilder resumo = new StringBuilder();
        if (quantidade1 > 0) {
            resumo.append("Pizza de Frango c/ Catupiry: ").append(quantidade1).append(" x R$ ").append(precoPizza1).append("\n");
        }
        if (quantidade2 > 0) {
            resumo.append("Pizza de Calabresa: ").append(quantidade2).append(" x R$ ").append(precoPizza2).append("\n");
        }
        if (quantidade3 > 0) {
            resumo.append("Pizza de Mussarela: ").append(quantidade3).append(" x R$ ").append(precoPizza3).append("\n");
        }
        if (quantidade4 > 0) {
            resumo.append("Pizza de Marguerita: ").append(quantidade4).append(" x R$ ").append(precoPizza4).append("\n");
        }

        // Exibe o resumo do pedido no TextView
        txtResultadoPedido.setText(resumo.toString());

        // Limpa os campos de quantidade
        qtdPizza1.setText("");
        qtdPizza2.setText("");
        qtdPizza3.setText("");
        qtdPizza4.setText("");
    }
    public void Sair(View view){
        finish();
    }
}