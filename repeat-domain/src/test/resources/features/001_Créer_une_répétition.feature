# language: fr
Fonctionnalité: Créer une répétition
  En tant que personne ayant 2 neurones
  Je veux créer une répétition
  Afin de ne pas l'oublier

  Scénario: Créer une répétition annuelle
    Etant donné que j'ai une répétition annuelle
    Lorsque je définis sa date de début à aujourd'hui
    Alors la date suivante est l'an prochain

  Scénario: Créer une répétition mensuelle
    Etant donné que j'ai une répétition mensuelle
    Lorsque je définis sa date de début à aujourd'hui
    Alors la date suivante est le mois prochain

  Scénario: Créer une répétition mensuelle
    Etant donné que j'ai une répétition mensuelle
    Lorsque je définis sa date de début au "31/01/2025"
    Alors la date suivante est le "28/02/2025"

  Scénario: Créer une répétition de périodicité quelconque
    Etant donné que j'ai une répétition de période 10 jours
    Lorsque je définis sa date de début au "01/01/2025"
    Alors la date suivante est le "11/01/2025"


  Plan du scénario: Créer une répétition de fin de mois en début de mois
    Etant donné que j'ai une répétition de fin de mois <nombre_jours> jours avant la fin du mois
    Lorsque je définis sa date de début au "<date de départ>"
    Alors la date suivante est le "<date suivante attendue>"
  Exemples:
    | nombre_jours | date de départ | date suivante attendue |
    | 5            | 01/01/2025     | 26/01/2025             |
    | 5            | 28/01/2025     | 23/02/2025             |
    | 0            | 28/02/2025     | 31/03/2025             |