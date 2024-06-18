import logging

# Настройка логирования
logging.basicConfig(level=logging.INFO)

class ComplexNumber:
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def __add__(self, other):
        logging.info("Сложение комплексных чисел")
        return ComplexNumber(self.real + other.real, self.imaginary + other.imaginary)

    def __mul__(self, other):
        logging.info("Умножение комплексных чисел")
        real = self.real * other.real - self.imaginary * other.imaginary
        imaginary = self.real * other.imaginary + self.imaginary * other.real
        return ComplexNumber(real, imaginary)

    def __truediv__(self, other):
        logging.info("Деление комплексных чисел")
        conjugate = ComplexNumber(other.real, -other.imaginary)
        numerator = self * conjugate
        denominator = other.real**2 + other.imaginary**2
        return ComplexNumber(numerator.real / denominator, numerator.imaginary / denominator)

    def __str__(self):
        return f"{self.real} + {self.imaginary}i"

# Пример использования калькулятора
num1 = ComplexNumber(1, 2)
num2 = ComplexNumber(3, 4)
print(f"Сумма: {num1 + num2}")
print(f"Произведение: {num1 * num2}")
print(f"Частное: {num1 / num2}")
