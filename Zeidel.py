from copy import copy
import numpy as np
from Simple_iteration import Simple_iteration
import matplotlib.pyplot as plt

class Zeidel(Simple_iteration):
    def __init__(self, e: float = 0.0001):
        super().__init__()
        self.e = e

    def solution(self) -> str:
        q = self.norm()
        m_x = [0.0, 0.0, 0.0]
        flag = True
        x_0 = copy(self.matrix_C)
        while flag:
            for i in range(self.size_of_matrix_B):
                temp = 0
                for j in range(self.size_of_matrix_B):
                    temp += x_0[j] * self.matrix_B[i][j]
                x_0[i] = temp + self.matrix_C[i]
            delta_x = np.array(x_0) - np.array(m_x)
            delta = self.max(delta_x)
            if (delta * q / (1 - q)) < self.e:
                flag = False
            m_x = copy(x_0)
            self.iterations += 1
            if not flag:
                return f"X0 = {x_0}\niteration = {self.iterations}"
        self.x = x_0