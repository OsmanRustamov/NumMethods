from Simple_iteration import Simple_iteration
from Zeidel import Zeidel
from Lagrange import Lagrange
from NewtonPolynom import Newton_polynom
import numpy as np


def newton():
    n = Newton_polynom(np.array([6, 8, 10]), 8.5)
    print(n.solution())
    n.draw_graph()

# newton()

def lagrange():
    l = Lagrange([6, 8, 10], 8.5)
    print(l.solution())
    l.draw_graph([6, 8, 10])

# lagrange()

def zeidel():
    z = Zeidel()
    print(z.solution())

# zeidel()

def simple_iter():
    s = Simple_iteration()
    print(s.solution())

# simple_iter()