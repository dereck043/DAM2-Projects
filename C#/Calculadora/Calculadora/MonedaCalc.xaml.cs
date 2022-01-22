using Calculadora.Modelo;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Calculadora
{
    /// <summary>
    /// Lógica de interacción para MonedaCalc.xaml
    /// </summary>
    public partial class MonedaCalc : Window
    {
        List<Moneda> monedas = new List<Moneda>();
        public MonedaCalc()
        {
            InitializeComponent();
            var url = "http://www.floatrates.com/daily/usd.json";

            WebRequest request = HttpWebRequest.Create(url);

            WebResponse response = request.GetResponse();

            StreamReader reader = new StreamReader(response.GetResponseStream());

            string responseText = reader.ReadToEnd();

            JObject joResponse = JObject.Parse(responseText);

            foreach (Object a in joResponse) {
                String b = a.ToString().Remove(0, 6);
                Moneda moneda = JsonConvert.DeserializeObject<Moneda>(b.Remove(b.ToString().Length - 1));
                this.fromCurrency.Items.Add(moneda.Name);
                this.toCurrency.Items.Add(moneda.Name);
                monedas.Add(moneda);
                 
            }

            this.fromCurrency.SelectedItem = "Euro";
            this.toCurrency.SelectedItem = "U.K. Pound Sterling";
        }

        private void btnCE_Click(object sender, RoutedEventArgs e)
        {
            this.response.Text = "0";
            calcChange();
        }

        private void btnRetroceder_Click(object sender, RoutedEventArgs e)
        {
            if (this.response.Text.Length > 0) {
                this.response.Text = this.response.Text.Remove(this.response.Text.Length - 1, 1);
                if (this.response.Text.Length == 0) {
                    this.response.Text = "0";
                }
                calcChange();
            }
            
        }

        private void openEstandar_Click(object sender, RoutedEventArgs e)
        {
            MainWindow m1 = new MainWindow();
            m1.Show();
            Application.Current.Windows[0].Close();
        }

        public void btnNum_Click(object sender, RoutedEventArgs e)
        {
            if (this.response.Text.Length > 11) {
                return;
            }

            if (((Button)sender).Content.ToString() != ",") {
                    this.response.Text = this.response.Text == "0" ? "" : this.response.Text;
            }
            this.response.Text += ((Button)sender).Content;

            calcChange();
        }

        private void calcChange() {
            Double raw = Double.Parse(this.response.Text);

            Moneda monFrom = monedas.Where(f => f.Name.Equals(this.fromCurrency.SelectedValue)).FirstOrDefault();
            Moneda mon = monedas.Where(f => f.Name.Equals(this.toCurrency.SelectedValue)).FirstOrDefault();

            if (mon != null)
            {
                Double res = (((raw / (Double.Parse(monFrom.Rate.Replace(".", ",")))) * Double.Parse(mon.Rate.Replace(".", ","))));
                res = Math.Truncate(res * 100) / 100;
                this.toResponse.Text = res + "";
            }
        }


    }
}
