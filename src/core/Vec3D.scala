package core

case class Vec3D(x: Double, y: Double, z: Double) {
  def magnitude: Double = {
    Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2))
  }

  def +(vec3D: Vec3D): Vec3D = {
    Vec3D(x + vec3D.x, y + vec3D.y, z + vec3D.z)
  }

  def -(vec3D: Vec3D): Vec3D = {
    Vec3D(x - vec3D.x, y - vec3D.y, z - vec3D.z)
  }

  def *(v: Double): Vec3D = {
    Vec3D(x * v, y * v, z * v)
  }

  def /(v: Double): Vec3D = {
    Vec3D(x / v, y / v, z / v)
  }

  override def toString: String = {
    f"($x%1.1f, $y%1.1f, $z%1.1f)"
  }
}
