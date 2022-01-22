using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Calculadora
{
    public partial class MainWindow : Window
    {

        Double numero1 = 0;
        Double numero2 = 0;
        string operacion = "";

        public MainWindow()
        {
            InitializeComponent();
        }

        public void btnNum_Click(object sender, RoutedEventArgs e){

            if (this.txtResultado.Text.Length > 16)
            {
                return;
            }

            if (((Button)sender).Content.ToString() != ",")
            {
                txtResultado.Text = txtResultado.Text == "0" || txtResultado.Text == "Undefined" ? "" : txtResultado.Text;
            }

            
            txtResultado.Text += ((Button)sender).Content;
        }

        public void saveNumber() {
            numero1 = txtResultado.Text!="Undefined"? Double.Parse(txtResultado.Text):0;
        }

        private void btnOperacion_Click(object sender, RoutedEventArgs e)
        {
            operacion = (string)((Button)sender).Content;
            saveNumber();
            txtResultado.Text = "0";
        }

        private void openMoneda(object sender, RoutedEventArgs e){
            MonedaCalc m1 = new MonedaCalc();
            m1.Show();
            Application.Current.Windows[0].Close();
        }


        private void btnResultado_Click(object sender, RoutedEventArgs e)
        {

            if (operacion=="") {
                return;
            }

            numero2 = txtResultado.Text!="Undefined"? Double.Parse(txtResultado.Text):0;
            switch (operacion)
            {
                case "+":
                    txtResultado.Text = (numero1 + numero2).ToString();
                    break;
                case "-":
                    txtResultado.Text = (numero1 - numero2).ToString();
                    break;
                case "*":
                    txtResultado.Text = (numero1 * numero2).ToString();
                    break;
                case "/":
                    txtResultado.Text = numero2>0?(numero1 / numero2).ToString():"Undefined";
                    break;

            }
            txtHistorial.Text += numero1 + operacion + numero2 + " = "+txtResultado.Text + Environment.NewLine;
            numero1 = 0;
            numero2 = 0;
            operacion = "";
        }

        private void btnCE_Click(object sender, RoutedEventArgs e)
        {
            txtResultado.Text = "0";
        }

        private void btnRetroceder_Click(object sender, RoutedEventArgs e)
        {
            if (this.txtResultado.Text.Length > 0)
            {
                this.txtResultado.Text = this.txtResultado.Text.Remove(this.txtResultado.Text.Length - 1, 1);
                if (this.txtResultado.Text.Length == 0)
                {
                    this.txtResultado.Text = "0";
                }
            }
        }

        private void btnPositivoNegativo_Click(object sender, RoutedEventArgs e)
        {
            txtResultado.Text = (-1 * Double.Parse(txtResultado.Text)).ToString();
        }

    }
}
