package com.example.calculator;

import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
            bplus, bminus, bmul, bdiv, bresult, bdot, bpi,
            bsin, bcos, btan, blog, bIn,
            bfact, bsquare, bsqrt, bpow, binv,
            bAC, bC, bb1, bb2;
    Button btnhistory;
    TextView tvmain, tvresult;
//    static String pi = "3.1415926536";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectid();
        // onclick
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b0.getText().toString());
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b1.getText().toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b2.getText().toString());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b3.getText().toString());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b4.getText().toString());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b5.getText().toString());
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b6.getText().toString());
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b7.getText().toString());
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b8.getText().toString());
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + b9.getText().toString());
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();

                if (val == "") {
                    Toast.makeText(MainActivity.this, "Định dạng đã dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                }
                else {
                   String tmp= convert(val);

                    if (UnaryOperator(String.valueOf(tmp.charAt(tmp.length() - 1))) == 2) { // ngoi ptu cuoi la 2
                        val = val.replace(String.valueOf(val.charAt(val.length() - 1)), bplus.getText().toString());
                        tvmain.setText(val);
                    } else {
                        if(tvresult.getText().toString().equals("") ){
                        tvmain.setText(val + bplus.getText().toString());}
                        else{
                            tvmain.setText(tvresult.getText().toString()+bplus.getText().toString());
                            tvresult.setText("");
                        }
                    }
                }
            }
        });
        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if (val == "") {
                    Toast.makeText(MainActivity.this, "Định dạng đã dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                }
                else {
                    String tmp= convert(val);
                    if (UnaryOperator(String.valueOf(tmp.charAt(tmp.length() - 1))) == 2) { // ngoi ptu cuoi la 2
                        val = val.replace(String.valueOf(val.charAt(val.length() - 1)), bminus.getText().toString());
                        tvmain.setText(val);
                    } else {
                        if(tvresult.getText().toString().equals("")){
                            tvmain.setText(val + bminus.getText().toString());}
                        else{
                            tvmain.setText(tvresult.getText().toString()+bminus.getText().toString());
                            tvresult.setText("");
                        }
                    }
                }

            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if (val == "") {
                    Toast.makeText(MainActivity.this, "Định dạng đã dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                }
                else {
                    String tmp= convert(val);
                    if (UnaryOperator(String.valueOf(tmp.charAt(tmp.length() - 1))) == 2) { // ngoi ptu cuoi la 2
                        val = val.replace(String.valueOf(val.charAt(val.length() - 1)), bmul.getText().toString());
                        tvmain.setText(val);
                    } else {
                        if(tvresult.getText().toString().equals("")){
                            tvmain.setText(val + bmul.getText().toString());}
                        else{
                            tvmain.setText(tvresult.getText().toString()+bmul.getText().toString());
                            tvresult.setText("");
                        }
                    }
                }
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if (val == "") {
                    Toast.makeText(MainActivity.this, "Định dạng đã dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                }
                else {
                    String tmp= convert(val);
                    if (UnaryOperator(String.valueOf(tmp.charAt(tmp.length() - 1))) == 2) { // ngoi ptu cuoi la 2
                        val = val.replace(String.valueOf(val.charAt(val.length() - 1)), bdiv.getText().toString());
                        tvmain.setText(val);
                    } else {
                        if(tvresult.getText().toString().equals("")){
                            tvmain.setText(val + bdiv.getText().toString());}
                        else{
                            tvmain.setText(tvresult.getText().toString()+bdiv.getText().toString());
                            tvresult.setText("");
                        }
                    }
                }
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + bb1.getText().toString());
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + bb2.getText().toString());
            }
        });

        bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                tvmain.setText(val + bpi.getText().toString());
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                val = val.substring(0, val.length() - 1);
                tvmain.setText(val);
            }
        });

        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if (val == "") {
                    tvmain.setText("0.");
                } else {
                    char last = val.charAt(val.length() - 1);
                    if (Character.isDigit(last)) {
                        // neu ki tu cuoi la so
                        tvmain.setText(val + bdot.getText().toString());
                    }
                }
            }
        });
        bAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                val = "";
                tvmain.setText(val);
                tvresult.setText("");
            }
        });

        bfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int val=Integer.parseInt(tvmain.getText().toString());
//                int gt=fact(val);
//                tvresult.setText(""+gt);
                tvmain.setText(tvmain.getText().toString() + "!");
            }
        });
        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + bsin.getText().toString()+"(");}
                else{
                    tvmain.setText(bsin.getText().toString()+"(");
                    tvresult.setText("");
                }

            }
        });
        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + bcos.getText().toString()+"(");}
                else{
                    tvmain.setText(bcos.getText().toString()+"(");
                    tvresult.setText("");
                }
            }
        });
        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + btan.getText().toString()+"(");}
                else{
                    tvmain.setText(btan.getText().toString()+"(");
                    tvresult.setText("");
                }
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + blog.getText().toString()+"(");}
                else{
                    tvmain.setText(blog.getText().toString()+"(");
                    tvresult.setText("");
                }
            }
        });
        bIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + bIn.getText().toString()+"(");}
                else{
                    tvmain.setText(bIn.getText().toString()+"(");
                    tvresult.setText("");
                }

            }
        });
        bpow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if (val == "") {
                    Toast.makeText(MainActivity.this, "Định dạng đã dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                }
                else {
                    String tmp= convert(val);
                    if (UnaryOperator(String.valueOf(tmp.charAt(tmp.length() - 1))) == 2) { // ngoi ptu cuoi la 2 thi k dat toan tu 2 ngoi nx
                        val = val.replace(String.valueOf(val.charAt(val.length() - 1)), bpow.getText().toString());
                        tvmain.setText(val);
                    } else {
                        if(tvresult.getText().toString().equals("")){
                            tvmain.setText(val + bpow.getText().toString());}
                        else{
                            tvmain.setText(tvresult.getText().toString()+bpow.getText().toString());
                            tvresult.setText("");
                        }
                    }
                }
            }
        });
        bsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + "^2");}
                else{
                    tvmain.setText(tvresult.getText().toString()+"^2");
                    tvresult.setText("");
                }
            }
        });
        bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + bsqrt.getText().toString()+"(");}
                else{
                    tvmain.setText(bsqrt.getText().toString()+"(");
                    tvresult.setText("");
                }
            }
        });
        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();
                if(tvresult.getText().toString().equals("")){
                    tvmain.setText(val + "1/(");}
                else{
                    tvmain.setText("1/(");
                    tvresult.setText("");
                }
            }
        });

        bresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = tvmain.getText().toString();

                if( (int) calPostfix(infixTopostfix(val)) == calPostfix(infixTopostfix(val)) ){
                    String ans=String.valueOf( (int) calPostfix(infixTopostfix(val)) );
                    tvresult.setText(ans);
                    // set text bo phan thap phan neu kq la so nguyen
                }
                else{
                tvresult.setText("" + calPostfix(infixTopostfix(val)));
               }

                Trunggian.kqpheptinh.add(val+" = "+tvresult.getText().toString());
            }
        });

        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void connectid() {
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        bplus = findViewById(R.id.bplus);
        bminus = findViewById(R.id.bminus);
        bmul = findViewById(R.id.bmul);
        bdiv = findViewById(R.id.bdiv);
        bresult = findViewById(R.id.bresult);
        bdot = findViewById(R.id.bdot);
        bpi = findViewById(R.id.bpi);
        bpi = findViewById(R.id.bpi);

        bsin = findViewById(R.id.bsin);
        bcos = findViewById(R.id.bcos);
        btan = findViewById(R.id.btan);
        blog = findViewById(R.id.blog);
        bIn = findViewById(R.id.bIn);

        bfact = findViewById(R.id.bfact);
        bsquare = findViewById(R.id.bsquare);
        bsqrt = findViewById(R.id.bsqrt);
        bpow = findViewById(R.id.bpow);
        binv = findViewById(R.id.binv);

        bAC = findViewById(R.id.bAC);
        bC = findViewById(R.id.bC);
        bb1 = findViewById(R.id.bb1);
        bb2 = findViewById(R.id.bb2);

        tvmain = findViewById(R.id.tvmain);
        tvresult = findViewById(R.id.tvresult);

        btnhistory=findViewById(R.id.btnhistory);
    }

    public static int fact(int n) {
        if (n == 1 || n == 0) return 1;
        return n * fact(n - 1);
    }


    // caculate
    public double calPostfix(Vector<String> s) {
        Stack<Double> stk = new Stack<>();
        for (int i = 0; i < s.size(); i++) {
            int temp = isOperator(s.get(i));
            if (temp != 0) {
                if (temp == 1) {
                        double a = stk.pop();
                        double b = stk.pop();
                        BigDecimal A=BigDecimal.valueOf(a);
                        BigDecimal B=BigDecimal.valueOf(b);
                        BigDecimal res=B.add(A);
                        double tmp;
                        tmp = res.doubleValue();
                        stk.push(tmp);
                }
                if (temp == 2) {
                    double a = stk.pop();
                    double b = stk.pop();
                    BigDecimal A=BigDecimal.valueOf(a);
                    BigDecimal B=BigDecimal.valueOf(b);
                    BigDecimal res=B.subtract(A);
                    double tmp;
                    tmp = res.doubleValue();
                    stk.push(tmp);
                }
                if (temp == 3) {
                    double a= stk.pop();
                    double b= stk.pop();
                    BigDecimal A=BigDecimal.valueOf(a);
                    BigDecimal B=BigDecimal.valueOf(b);
                    BigDecimal res=B.multiply(A);
                    double tmp;
                    tmp = res.doubleValue();
                    stk.push(tmp);
                }
                if (temp == 4) {
                    double a= stk.pop();
                    double b= stk.pop();
                    double tmp;
                    tmp=b/a;
                    stk.push(tmp);
                }
                if (temp == 5) {
                    double a = stk.pop();
                    double b = stk.pop();
                    double tmp;
                    tmp = pow(b, a);
                    stk.push(tmp);
                }
                if (temp == 6) {
                    double a = stk.pop();
                    int tmp = fact((int) a);
                    stk.push((double) tmp);
                }
                if (temp == 7) {
                    double a = stk.pop();
                    BigDecimal A=BigDecimal.valueOf(a);
                    BigDecimal res=(BigDecimal.valueOf(sin(a))).setScale(10, RoundingMode.HALF_UP);
                    double tmp;
                    tmp = res.doubleValue();
                    stk.push(tmp);
                }
                if (temp == 8) {
                    double a = stk.pop();
                    BigDecimal A=BigDecimal.valueOf(a);
                    BigDecimal res=(BigDecimal.valueOf(cos(a))).setScale(10, RoundingMode.HALF_UP);
                    double tmp;
                    tmp = res.doubleValue();
                    stk.push(tmp);
                }
                if (temp == 9) {
                    double a = stk.pop();
                    BigDecimal A=BigDecimal.valueOf(a);
                    BigDecimal res=(BigDecimal.valueOf(tan(a))).setScale(10, RoundingMode.HALF_UP);
                    double tmp;
                    tmp = res.doubleValue();
                    stk.push(tmp);

                }
                if (temp == 10) {
                    double a = stk.pop();
                    double tmp;
                    tmp = log(a);
                    stk.push(tmp);
                }
                if (temp == 11) {
                    double a = stk.pop();
                    double tmp;
                    tmp = log10(a);
                    stk.push(tmp);
                }
                if (temp == 12) {
                    double a = stk.pop();
                    double tmp;
                    tmp = sqrt(a);
                    stk.push(tmp);
                }
                if(temp == 13){
                    double a=stk.pop();
                    double tmp= -a;
                    stk.push(tmp);
                }
            } else {
                    double a;
                    if (s.get(i).equals("π")) {
                        a = PI;
                    }
                    else {
                        a = parseDouble(s.get(i));
                    }
                    stk.push(a);
            }
        }
        return stk.peek();
    }

    // trung to sang hau to
    // nhập đủ ngoặc mới tính cho
    public static Vector<String> infixTopostfix(String s) {
        // chuyen doi s
       s= convert(s);
        Stack<Character> stk = new Stack<>();
        Vector<String> res = new Vector<>();
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') // k p la dau ngoac {
                if (isOperator(s.charAt(i)) == 0) {
                    // toan hang
                    tmp += String.valueOf(s.charAt(i)); // chuyen char sang string
                } else { // toan tu
                    if (tmp != "") {
                        res.add(tmp);
                        tmp = "";
                    }
                    if (stk.empty() || stk.peek() == '(' || degree(s.charAt(i)) == 6 || degree(s.charAt(i)) > degree(stk.peek())) {
                        stk.push(s.charAt(i));
                    } else {
                        while (!stk.empty() && degree(s.charAt(i)) <= degree(stk.peek())) {
                            res.add(String.valueOf(stk.peek()));
                            stk.pop();
                        }
                        stk.push(s.charAt(i));
                    }
                }
            else { // dau ( hoac )
                if (tmp != "") {
                    res.add(tmp);
                    tmp = "";
                }
                if (s.charAt(i) == '(') stk.push(s.charAt(i));
                else {
                    char c = stk.pop();
                    while (c != '(') {
                        res.add(String.valueOf(c));
                        c = stk.pop();
                    }
                }
            }
        }
        if (tmp != "") {
            res.add(tmp);
            tmp = "";
        }
        while (!stk.empty()) {
            char c = stk.pop();
            res.add(String.valueOf(c));
        }
        return res;
    }

    public static int degree(char c) {
        if (c == '^' || c == '!' || c == 's' || c == 'c' || c == 't' || c == 'l' || c == 'I' || c == '√' || c == 'N')
            return 6;
        if (c == '*' || c == '/') return 5;
        if (c == '+' || c == '-') return 4;
        return 0;
    }

    public static int isOperator(char op) {
        if ((op == '+') || (op == 'N') || (op == '-') || (op == '!') || (op == 's') || (op == 'c') || (op == 't') || (op == 'l') || (op == 'I') || (op == '√') || (op == '*') || (op == '/') || (op == '^'))
            return 1;
        else return 0;
    }

    public static int isOperator(String str) {
        if (str.equals("+")) return 1;
        else if (str.equals("-")) return 2;
        else if (str.equals("*")) return 3;
        else if (str.equals("/")) return 4;
        else if (str.equals("^")) return 5;
        else if (str.equals("!")) return 6;
        else if (str.equals("s")) return 7;
        else if (str.equals("c")) return 8;
        else if (str.equals("t")) return 9;
        else if (str.equals("I")) return 10;
        else if (str.equals("l")) return 11;
        else if (str.equals("√")) return 12;
        else if (str.equals("N")) return 13;

        else return 0;
    }

// khong de toan tu 2 ngoi nhap canh nhau
public int UnaryOperator(String str){
    if(str.equals("*") || str.equals("/") || str.equals("^") || str.equals("+") || str.equals("-")) return 2;
    return 1;
}

// chuyen doi chuoi
    public static String convert(String s){
        if (s.contains("sin")) {
            s = s.replace("sin", "s");
        }
        if (s.contains("cos")) {
            s = s.replace("cos", "c");
        }
        if (s.contains("tan")) {
            s = s.replace("tan", "t");
        }
        if (s.contains("log")) {
            s = s.replace("log", "l");
        }
        if (s.contains("In")) {
            s = s.replace("In", "I");
        }
        if (s.contains("x")) {
            s = s.replace("x", "*");
        }
        if (s.contains("÷")) {
            s = s.replace("÷", "/");
        }

        if (s.charAt(0) == '-') { // kiểm tra số âm
            // Tạo một chuỗi mới với ký tự đầu tiên là 'N'
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(0, 'N');
            s= sb.toString();}

        if( s.contains("(-")){
            // Xử lý trường hợp "(-"
           // thay thế hết tất cả các dấu âm thành N
                    s=s.replace("(-","(N");
            }
        return s;
        }
}









