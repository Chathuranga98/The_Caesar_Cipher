object CeasarCipher extends App{
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  val encrypt = (c: Char, key: Int, alphabet: String) => alphabet((alphabet.indexOf(c.toUpper) + key) % alphabet.size)
  val decrypt = (c: Char, key: Int, alphabet: String) => alphabet((alphabet.indexOf(c.toUpper) - key + alphabet.size) % alphabet.size)

  val cipher = (algo: (Char, Int, String) => Char, s: String, key: Int, alphabet: String) => s.map(algo(_,key,alphabet))

  val shift = (scala.io.StdIn.readLine("Shifted By: ").toInt + alphabet.size) % alphabet.size
  val text = scala.io.StdIn.readLine("Enter secret Message to encrypt: ")

  val et = cipher( encrypt, text, shift, alphabet)
  val dt = cipher(decrypt, et, shift, alphabet)

  print("Encrypted message is : ")
  println(et)
  print("Decrypted message is : ")
  println(dt)

}