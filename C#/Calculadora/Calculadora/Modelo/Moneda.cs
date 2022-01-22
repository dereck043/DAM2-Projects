using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculadora.Modelo
{
    public class Moneda
    {
        String code, alphaCode, numericCode, name, rate, date, inverseRate;

        public Moneda()
        {
        }

        public Moneda(string code, string alphaCode, string numericCode, string name, string rate, string date, string inverseRate)
        {
            this.Code = code;
            this.AlphaCode = alphaCode;
            this.NumericCode = numericCode;
            this.Name = name;
            this.Rate = rate;
            this.Date = date;
            this.InverseRate = inverseRate;
        }

        public string Code { get => code; set => code = value; }
        public string AlphaCode { get => alphaCode; set => alphaCode = value; }
        public string NumericCode { get => numericCode; set => numericCode = value; }
        public string Name { get => name; set => name = value; }
        public string Rate { get => rate; set => rate = value; }
        public string Date { get => date; set => date = value; }
        public string InverseRate { get => inverseRate; set => inverseRate = value; }
    }
}
