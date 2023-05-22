import matplotlib.pyplot as plt
class Gauss():
    def __init__(self, a: int, b: int):
        self.a = a
        self.b = b
        self.A = [0.236927, 0.478629, 0.568889, 0.478629, 0.236927]
        self.t = [-0.90618, -0.538469, 0.0, 0.538469, 0.90618]

    def func(self, x:float) -> float:
        return 1 + x**2 - 2 * x

    def solution(self) -> float:
        res = 0
        for i in range(len(self.A)):
            n = ((self.a + self.b) / 2) + ((self.b - self.a) / 2) * self.t[i]
            res += self.A[i] * self.func(n)
        res *= (self.b - self.a) / 2
        return abs(res)

    def draw_graph(self):
        plt.plot(self.x_values, self.lagrange_values, label='Полином Лагранжа')
        plt.plot(self.x_values, self.f_values, label='f(x)')
        plt.scatter(x, self.y, color='red', label='Узлы интерполяции')
        plt.scatter(self.a, self.lagrange_value, color='green', label='Значение полинома в точке a')
        plt.legend()
        plt.xlabel('x')
        plt.ylabel('y')
        plt.title('Метод Гаусса')
        plt.grid(True)
        plt.show()